package com.nexters.lettero.presentation.login.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.credentials.Credential
import com.google.android.gms.auth.api.credentials.Credentials
import com.google.android.gms.auth.api.credentials.HintRequest
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentPhoneAuthBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.login.viewmodel.PhoneAuthViewModel

class PhoneAuthFragment : BaseFragment<FragmentPhoneAuthBinding, PhoneAuthViewModel>() {
    override val layoutRes: Int = R.layout.fragment_phone_auth
    override var viewModel: ViewModel = PhoneAuthViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel as PhoneAuthViewModel
        binding.phoneAuthNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        binding.viewmodel?.navController = findNavController()

        requestPhoneNumber()
    }

    //사용자 기기 전화번호 추출
    private fun requestPhoneNumber() {
        val reqPhoneNumber =
            registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) {
                if (it.resultCode != Activity.RESULT_OK) return@registerForActivityResult

                val credential: Credential? = it.data?.getParcelableExtra(Credential.EXTRA_KEY)
                val phoneNumber = credential?.id?.replace("+82", "0")

                (viewModel as PhoneAuthViewModel).phoneNumber.set(phoneNumber)
            }

        val hintReq = HintRequest.Builder().setPhoneNumberIdentifierSupported(true).build()
        val intent = Credentials.getClient(context as Context).getHintPickerIntent(hintReq)
        reqPhoneNumber.launch(IntentSenderRequest.Builder(intent.intentSender).build())
    }
}
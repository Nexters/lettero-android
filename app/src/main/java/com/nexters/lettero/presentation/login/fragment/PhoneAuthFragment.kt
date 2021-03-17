package com.nexters.lettero.presentation.login.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.credentials.Credentials
import com.google.android.gms.auth.api.credentials.HintRequest
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentPhoneAuthBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.login.viewmodel.PhoneAuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class PhoneAuthFragment : BaseFragment<FragmentPhoneAuthBinding, PhoneAuthViewModel>() {
    override val layoutRes: Int = R.layout.fragment_phone_auth

    @Inject
    override lateinit var viewModel: PhoneAuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.view = this
        binding.viewmodel = viewModel
        binding.phoneAuthNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher())

        requestPhoneNumber()
        moveToMainFragment()
        showMessage()
    }

    //사용자 기기 전화번호 추출
    private fun requestPhoneNumber() {
        val reqPhoneNumber =
            registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) {
                if (it.resultCode != Activity.RESULT_OK) return@registerForActivityResult

                (binding.viewmodel as PhoneAuthViewModel).setPhoneNumber(it.data)
            }

        val hintReq = HintRequest.Builder().setPhoneNumberIdentifierSupported(true).build()
        val intent = Credentials.getClient(context as Context).getHintPickerIntent(hintReq)
        reqPhoneNumber.launch(IntentSenderRequest.Builder(intent.intentSender).build())
    }

    fun moveToMainFragment() {
        (viewModel as PhoneAuthViewModel).resultAuthOk.observe(viewLifecycleOwner, Observer {
            if(it)
                findNavController().navigate(R.id.action_phoneAuthFragment_to_mainFragment)
        })
    }

    fun requestPhoneAuth(view: View) {
        viewModel.phoneNumber.value?.let {
            viewModel.parsePhoneE164Number(it, Locale.getDefault())?.let { parsedValue ->
                val option = PhoneAuthOptions.newBuilder()
                    .setPhoneNumber(parsedValue)
                    .setTimeout(viewModel.MAX_SECOND, TimeUnit.SECONDS)
                    .setActivity(requireActivity())
                    .setCallbacks(viewModel)
                    .build()

                PhoneAuthProvider.verifyPhoneNumber(option)
            }
        }
    }

    fun backLogin(view: View) {
        findNavController().popBackStack()
    }

    fun showMessage() {
        viewModel.message.observe(viewLifecycleOwner, Observer {
            it?.let{
                Toast.makeText(requireContext(), getString(it), Toast.LENGTH_SHORT).show()
            }
        })
    }
}
package com.nexters.lettero.presentation.sms.fragment

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentSendSmsBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.sms.viewmodel.SendSmsViewModel

class SendSmsFragment : BaseFragment<FragmentSendSmsBinding, SendSmsViewModel>() {
    override val layoutRes: Int = R.layout.fragment_send_sms
    override var viewModel: SendSmsViewModel = SendSmsViewModel()

    private val sendResult = Observer<Boolean> { result ->
        if (result) {
            findNavController().navigate(R.id.action_sendSmsFragment_to_sendResultDialogFragment)
            (viewModel as SendSmsViewModel).initDefaultValue()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.view = this
        binding.viewmodel = viewModel as? SendSmsViewModel

        init()
    }

    fun init() {
        binding.receiverEdittext.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        binding.sendMsgContent.addTextChangedListener { edtResult ->
            (viewModel as SendSmsViewModel).setMsgChangeResult(edtResult)
        }

        (viewModel as SendSmsViewModel).sendResult.observe(viewLifecycleOwner, sendResult)
        observeDialogResult()
    }

    fun observeDialogResult() {
        val navBackStackEntry = findNavController().getBackStackEntry(R.id.sendSmsFragment)

        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME
                && navBackStackEntry.savedStateHandle.contains("isAnonymous")
            ) {
                val result = navBackStackEntry.savedStateHandle.get<Boolean>("isAnonymous");

                (viewModel as SendSmsViewModel).isAnonymous.value = result
            }
        }
        navBackStackEntry.lifecycle.addObserver(observer)

        viewLifecycleOwner.lifecycle.addObserver(LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_DESTROY) {
                navBackStackEntry.lifecycle.removeObserver(observer)
            }
        })
    }

    fun moveToBack(view: View) {
        findNavController().popBackStack()
    }

    fun startUserNameDialog(view: View) {
        val bundle =
            bundleOf("isAnonymous" to (viewModel as SendSmsViewModel).isAnonymous.value)
        findNavController().navigate(
            R.id.action_sendSmsFragment_to_userNameDialogFragment,
            bundle
        )
    }
}

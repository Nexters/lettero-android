package com.nexters.lettero.presentation.message.fragment

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentSendMessageBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.message.viewmodel.SendMessageViewModel

class SendMessageFragment : BaseFragment<FragmentSendMessageBinding, SendMessageViewModel>() {
    override val layoutRes: Int = R.layout.fragment_send_message
    override var viewModel: SendMessageViewModel = SendMessageViewModel()

    private val sendResult = Observer<Boolean?> { result ->
        result?.let {
            if (result) {
                findNavController().navigate(R.id.action_sendMessageFragment2_to_sendResultDialogFragment)
                (viewModel as SendMessageViewModel).initDefaultValue()
            } else { Toast.makeText(context, getString(R.string.send_msg_err), Toast.LENGTH_LONG).show() }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.view = this
        binding.viewmodel = viewModel as? SendMessageViewModel

        init()
    }

    fun init() {
        binding.receiverEdittext.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        binding.sendMsgContent.addTextChangedListener { edtResult ->
            (viewModel as SendMessageViewModel).setMsgChangeResult(edtResult)
        }

        (viewModel as SendMessageViewModel).sendResult.observe(viewLifecycleOwner, sendResult)
        observeDialogResult()
    }

    fun observeDialogResult() {
        val navBackStackEntry = findNavController().getBackStackEntry(R.id.sendMessageFragment)

        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME
                && navBackStackEntry.savedStateHandle.contains("isAnonymous")
            ) {
                val result = navBackStackEntry.savedStateHandle.get<Boolean>("isAnonymous");

                (viewModel as SendMessageViewModel).isAnonymous.value = result
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
            bundleOf("isAnonymous" to (viewModel as SendMessageViewModel).isAnonymous.value)
        findNavController().navigate(
            R.id.action_sendMessageFragment_to_userNameDialogFragment,
            bundle
        )
    }
}

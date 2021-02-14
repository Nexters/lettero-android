package com.nexters.lettero.presentation.message.fragment

import android.content.Intent
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentSendMessageBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.message.viewmodel.SendMessageViewModel

class SendMessageFragment : BaseFragment<FragmentSendMessageBinding, SendMessageViewModel>() {
    override val layoutRes: Int = R.layout.fragment_send_message
    override var viewModel: ViewModel = SendMessageViewModel()

    private val sendResult = Observer<Boolean> { result ->
        if(result) {
            findNavController().navigate(R.id.action_sendMessageFragment2_to_sendResultDialogFragment)
            (viewModel as SendMessageViewModel).initDefaultValue()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.view = this
        binding.viewmodel = viewModel as? SendMessageViewModel

        init()
        (viewModel as SendMessageViewModel).isAnonymous.value = arguments?.get("isAnonymous") as? Boolean
    }

    fun init() {
        binding.receiverEdittext.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        binding.sendMsgContent.addTextChangedListener { edtResult ->
            (viewModel as SendMessageViewModel).setMsgChangeResult(edtResult)
        }

        (viewModel as SendMessageViewModel).sendResult.observe(viewLifecycleOwner, sendResult)
    }

    fun moveToBack(view: View) {
        findNavController().popBackStack()
    }

    fun startUserNameDialog(view: View) {
        val bundle = bundleOf("isAnonymous" to (viewModel as SendMessageViewModel).isAnonymous.value)
        findNavController().navigate(R.id.action_sendMessageFragment2_to_userNameDialogFragment, bundle)
    }
}

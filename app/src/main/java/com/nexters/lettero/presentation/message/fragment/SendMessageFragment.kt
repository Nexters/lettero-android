package com.nexters.lettero.presentation.message.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentSendMessageBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.BaseViewModel
import com.nexters.lettero.presentation.message.viewmodel.SendMessageBaseViewModel

class SendMessageFragment : BaseFragment<FragmentSendMessageBinding, SendMessageBaseViewModel>() {
    override val layoutRes: Int = R.layout.fragment_send_message
    override var viewModel: BaseViewModel = SendMessageBaseViewModel()
}

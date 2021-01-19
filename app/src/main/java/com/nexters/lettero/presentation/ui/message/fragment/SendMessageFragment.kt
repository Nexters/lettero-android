package com.nexters.lettero.presentation.ui.message.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentSendMessageBinding
import com.nexters.lettero.presentation.ui.base.BaseFragment
import com.nexters.lettero.presentation.ui.base.ViewModel
import com.nexters.lettero.presentation.ui.message.viewmodel.SendMessageViewModel

class SendMessageFragment : BaseFragment<FragmentSendMessageBinding, SendMessageViewModel>() {
    override val layoutRes: Int = R.layout.fragment_send_message
    override var viewModel: ViewModel = SendMessageViewModel()
}

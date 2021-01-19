package com.nexters.lettero.presentation.message.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentReadMessageBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.message.viewmodel.ReadMessageViewModel

class ReadMessageFragment : BaseFragment<FragmentReadMessageBinding, ReadMessageViewModel>() {
    override val layoutRes: Int = R.layout.fragment_read_message
    override var viewModel: ViewModel = ReadMessageViewModel()
}

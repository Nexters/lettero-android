package com.nexters.lettero.presentation.message.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentReadMessageBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.BaseViewModel
import com.nexters.lettero.presentation.message.viewmodel.ReadMessageBaseViewModel

class ReadMessageFragment : BaseFragment<FragmentReadMessageBinding, ReadMessageBaseViewModel>() {
    override val layoutRes: Int = R.layout.fragment_read_message
    override var viewModel: BaseViewModel = ReadMessageBaseViewModel()
}

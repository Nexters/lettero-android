package com.nexters.lettero.presentation.sms.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentReadSmsBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.sms.viewmodel.ReadSmsViewModel

class ReadSmsFragment : BaseFragment<FragmentReadSmsBinding, ReadSmsViewModel>() {
    override val layoutRes: Int = R.layout.fragment_read_sms
    override var viewModel: ReadSmsViewModel = ReadSmsViewModel()
}

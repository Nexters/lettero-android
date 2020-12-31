package com.nexters.lettero.presentation.main.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentSmsBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.main.viewmodel.SmsViewModel

class SmsFragment : BaseFragment<FragmentSmsBinding, SmsViewModel>() {
    override val layoutRes: Int = R.layout.fragment_sms
    override var viewModel: SmsViewModel = SmsViewModel()
}

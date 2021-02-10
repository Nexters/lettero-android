package com.nexters.lettero.presentation.login.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentLoginBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.login.viewmodel.PhoneAuthViewModel

class PhonAuthFragment : BaseFragment<FragmentLoginBinding, PhoneAuthViewModel>() {
    override val layoutRes: Int = R.layout.fragment_phone_auth
    override var viewModel: ViewModel = PhoneAuthViewModel()

    
}
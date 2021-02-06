package com.nexters.lettero.presentation.login.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentLoginBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.login.viewmodel.LoginViewModel

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override val layoutRes: Int = R.layout.fragment_login
    override var viewModel: ViewModel = LoginViewModel()
}
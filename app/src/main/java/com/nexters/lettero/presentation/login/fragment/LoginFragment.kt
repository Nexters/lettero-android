package com.nexters.lettero.presentation.login.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentLoginBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.BaseViewModel
import com.nexters.lettero.presentation.login.viewmodel.LoginBaseViewModel

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginBaseViewModel>() {
    override val layoutRes: Int = R.layout.fragment_login
    override var viewModel: BaseViewModel = LoginBaseViewModel()
}
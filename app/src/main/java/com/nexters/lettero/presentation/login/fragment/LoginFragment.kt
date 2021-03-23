package com.nexters.lettero.presentation.login.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentLoginBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override val layoutRes: Int = R.layout.fragment_login

    @Inject
    override lateinit var viewModel: LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loginResult.observe(viewLifecycleOwner) { result ->
            if (result) {
                viewModel.requestUserMe()
            } else {
                Toast.makeText(context, getString(R.string.kakao_login_failure), Toast.LENGTH_SHORT)
                    .show()
            }
        }

        viewModel.isNeedPhoneAuth.observe(viewLifecycleOwner) { isNeed ->
            isNeed?.let {
                if(it)
                    navigateToPhoneAuthFragment(findNavController())
                else
                    navigateToPhoneAuthFragment(findNavController())
            }
        }
    }

    private fun navigateToMainFragment(navController: NavController) {
        val action = LoginFragmentDirections.actionLoginFragmentToMainFragment()
        navController.navigate(action)
    }

    private fun navigateToPhoneAuthFragment(navController: NavController) {
        val action = LoginFragmentDirections.actionLoginFragmentToPhoneAuthFragment()
        navController.navigate(action)
    }
}
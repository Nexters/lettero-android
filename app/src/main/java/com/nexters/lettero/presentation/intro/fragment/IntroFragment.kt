package com.nexters.lettero.presentation.intro.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentIntroBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.intro.viewmodel.IntroViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class IntroFragment : BaseFragment<FragmentIntroBinding, IntroViewModel>() {
    override val layoutRes: Int = R.layout.fragment_intro

    @Inject
    override lateinit var viewModel: IntroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        register(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.tokenResult.observe(viewLifecycleOwner) { result ->
            viewLifecycleOwner.lifecycleScope.launch {
                delay(1000)

                if (result) {
                    navigateToMainFragment(view.findNavController())
                } else {
                    navigateToLoginFragment(view.findNavController())
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregister(viewModel)
    }

    private fun navigateToLoginFragment(navController: NavController) {
        val action = IntroFragmentDirections.actionIntroFragmentToLoginFragment()
        navController.navigate(action)
    }

    private fun navigateToMainFragment(navController: NavController) {
        val action = IntroFragmentDirections.actionIntroFragmentToMainFragment()
        navController.navigate(action)
    }
}
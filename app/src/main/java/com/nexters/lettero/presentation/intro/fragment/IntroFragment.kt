package com.nexters.lettero.presentation.intro.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentIntroBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.intro.viewmodel.IntroViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class IntroFragment : BaseFragment<FragmentIntroBinding, IntroViewModel>() {
    override val layoutRes: Int = R.layout.fragment_intro
    override var viewModel: ViewModel = IntroViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            delay(1000)

            val action = IntroFragmentDirections.actionIntroFragmentToLoginFragment()
            view.findNavController().navigate(action)
        }
    }
}
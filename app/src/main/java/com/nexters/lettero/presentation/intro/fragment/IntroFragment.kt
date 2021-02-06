package com.nexters.lettero.presentation.intro.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentIntroBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.intro.viewmodel.IntroViewModel
import com.nexters.lettero.presentation.main.viewmodel.MainViewModel

class IntroFragment : BaseFragment<FragmentIntroBinding, IntroViewModel>() {
    override val layoutRes: Int = R.layout.fragment_intro
    override var viewModel: ViewModel = MainViewModel()
}
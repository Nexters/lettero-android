package com.nexters.lettero.presentation.intro.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentIntroBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.BaseViewModel
import com.nexters.lettero.presentation.intro.viewmodel.IntroBaseViewModel
import com.nexters.lettero.presentation.main.viewmodel.MainBaseViewModel

class IntroFragment : BaseFragment<FragmentIntroBinding, IntroBaseViewModel>() {
    override val layoutRes: Int = R.layout.fragment_intro
    override var viewModel: BaseViewModel = MainBaseViewModel()
}
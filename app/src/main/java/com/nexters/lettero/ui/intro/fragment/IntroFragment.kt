package com.nexters.lettero.ui.intro.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentIntroBinding
import com.nexters.lettero.ui.base.BaseFragment
import com.nexters.lettero.ui.base.ViewModel
import com.nexters.lettero.ui.intro.viewmodel.IntroViewModel
import com.nexters.lettero.ui.main.viewmodel.MainViewModel

class IntroFragment : BaseFragment<FragmentIntroBinding, IntroViewModel>() {
    override val layoutRes: Int = R.layout.fragment_intro
    override var viewModel: ViewModel = MainViewModel()
}
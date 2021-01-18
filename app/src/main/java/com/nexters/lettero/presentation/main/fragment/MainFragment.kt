package com.nexters.lettero.presentation.main.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentMainBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.BaseViewModel
import com.nexters.lettero.presentation.main.viewmodel.MainBaseViewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainBaseViewModel>() {
    override val layoutRes: Int = R.layout.fragment_main
    override var viewModel: BaseViewModel = MainBaseViewModel()
}

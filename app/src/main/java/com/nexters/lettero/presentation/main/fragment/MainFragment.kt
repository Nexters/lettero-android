package com.nexters.lettero.presentation.main.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentMainBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.main.viewmodel.MainViewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override val layoutRes: Int = R.layout.fragment_main
    override var viewModel: ViewModel = MainViewModel()
}

package com.nexters.lettero.presentation.ui.main.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentMainBinding
import com.nexters.lettero.presentation.ui.base.BaseFragment
import com.nexters.lettero.presentation.ui.base.ViewModel
import com.nexters.lettero.presentation.ui.main.viewmodel.MainViewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override val layoutRes: Int = R.layout.fragment_main
    override var viewModel: ViewModel = MainViewModel()
}

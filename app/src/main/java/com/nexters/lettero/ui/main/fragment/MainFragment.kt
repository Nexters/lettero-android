package com.nexters.lettero.ui.main.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentMainBinding
import com.nexters.lettero.ui.base.BaseFragment
import com.nexters.lettero.ui.base.ViewModel
import com.nexters.lettero.ui.main.viewmodel.MainViewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override val layoutRes: Int = R.layout.fragment_main
    override var viewModel: ViewModel = MainViewModel()
}

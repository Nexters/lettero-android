package com.nexters.lettero.presentation.main.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentHomeBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.main.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutRes: Int = R.layout.fragment_home

    @Inject
    override lateinit var viewModel: HomeViewModel
}

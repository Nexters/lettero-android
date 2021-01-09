package com.nexters.lettero.presentation.main.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentOutBoxBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.main.viewmodel.OutBoxViewModel

class OutBoxFragment : BaseFragment<FragmentOutBoxBinding, OutBoxViewModel>() {
    override val layoutRes: Int = R.layout.fragment_out_box
    override var viewModel: OutBoxViewModel = OutBoxViewModel()
}

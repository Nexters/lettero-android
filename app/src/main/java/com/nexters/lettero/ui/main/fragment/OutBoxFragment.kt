package com.nexters.lettero.ui.main.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentOutBoxBinding
import com.nexters.lettero.ui.base.BaseFragment
import com.nexters.lettero.ui.base.ViewModel
import com.nexters.lettero.ui.main.viewmodel.OutBoxViewModel

class OutBoxFragment : BaseFragment<FragmentOutBoxBinding, OutBoxViewModel>() {
    override val layoutRes: Int = R.layout.fragment_out_box
    override var viewModel: ViewModel = OutBoxViewModel()
}

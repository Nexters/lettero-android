package com.nexters.lettero.presentation.ui.main.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentInBoxBinding
import com.nexters.lettero.presentation.ui.base.BaseFragment
import com.nexters.lettero.presentation.ui.base.ViewModel
import com.nexters.lettero.presentation.ui.main.viewmodel.InBoxViewModel

class InBoxFragment : BaseFragment<FragmentInBoxBinding, InBoxViewModel>() {
    override val layoutRes: Int = R.layout.fragment_in_box
    override var viewModel: ViewModel = InBoxViewModel()
}

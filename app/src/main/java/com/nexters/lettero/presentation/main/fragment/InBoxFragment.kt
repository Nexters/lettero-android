package com.nexters.lettero.presentation.main.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentInBoxBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.BaseViewModel
import com.nexters.lettero.presentation.main.viewmodel.InBoxBaseViewModel

class InBoxFragment : BaseFragment<FragmentInBoxBinding, InBoxBaseViewModel>() {
    override val layoutRes: Int = R.layout.fragment_in_box
    override var viewModel: BaseViewModel = InBoxBaseViewModel()
}

package com.nexters.lettero.presentation.ui.mypage.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentMyPageBinding
import com.nexters.lettero.presentation.ui.base.BaseFragment
import com.nexters.lettero.presentation.ui.base.ViewModel
import com.nexters.lettero.presentation.ui.mypage.viewmodel.MyPageViewModel

class MyPageFragment : BaseFragment<FragmentMyPageBinding, MyPageViewModel>() {
    override val layoutRes: Int = R.layout.fragment_my_page
    override var viewModel: ViewModel = MyPageViewModel()
}

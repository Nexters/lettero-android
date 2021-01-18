package com.nexters.lettero.presentation.mypage.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentMyPageBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.BaseViewModel
import com.nexters.lettero.presentation.mypage.viewmodel.MyPageBaseViewModel

class MyPageFragment : BaseFragment<FragmentMyPageBinding, MyPageBaseViewModel>() {
    override val layoutRes: Int = R.layout.fragment_my_page
    override var viewModel: BaseViewModel = MyPageBaseViewModel()
}

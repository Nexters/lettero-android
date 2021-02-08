package com.nexters.lettero.presentation.mypage.fragment

import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentMyPageBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.mypage.viewmodel.MyPageViewModel

class SettingFragment : BaseFragment<FragmentMyPageBinding, MyPageViewModel>() {
    override val layoutRes: Int = R.layout.fragment_app_setting
    override var viewModel: ViewModel = MyPageViewModel()
}

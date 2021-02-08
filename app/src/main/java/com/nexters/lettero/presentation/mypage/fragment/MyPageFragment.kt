package com.nexters.lettero.presentation.mypage.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentMyPageBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.mypage.viewmodel.MyPageViewModel

class MyPageFragment : BaseFragment<FragmentMyPageBinding, MyPageViewModel>() {
    override val layoutRes: Int = R.layout.fragment_my_page
    override var viewModel: ViewModel = MyPageViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMyPageBinding>(layoutInflater, layoutRes, container, false)
        binding.vm = viewModel as MyPageViewModel

        return binding.root
    }
}

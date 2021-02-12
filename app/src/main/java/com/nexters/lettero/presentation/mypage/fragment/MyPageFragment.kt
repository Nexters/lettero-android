package com.nexters.lettero.presentation.mypage.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentMyPageBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.mypage.viewmodel.MyPageViewModel

class MyPageFragment : BaseFragment<FragmentMyPageBinding, MyPageViewModel>() {
    override val layoutRes: Int = R.layout.fragment_my_page
    override var viewModel: ViewModel = MyPageViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.view = this
        binding.vm = viewModel as MyPageViewModel
    }

    fun moveToAppSetting(view: View) {
        findNavController().navigate(R.id.action_myPageFragment_to_settingFragment)
    }
}

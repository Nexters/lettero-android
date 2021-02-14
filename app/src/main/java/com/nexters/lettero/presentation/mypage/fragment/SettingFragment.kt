package com.nexters.lettero.presentation.mypage.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentAppSettingBinding
import com.nexters.lettero.databinding.FragmentMyPageBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.mypage.viewmodel.MyPageViewModel
import com.nexters.lettero.presentation.mypage.viewmodel.SettingViewModel

class SettingFragment : BaseFragment<FragmentAppSettingBinding, SettingViewModel>() {
    override val layoutRes: Int = R.layout.fragment_app_setting
    override var viewModel: ViewModel = SettingViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.view = this
        binding.vm = viewModel as SettingViewModel
    }

    fun moveToWeb(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    fun moveBack(view: View) {
        findNavController().popBackStack()
    }
}

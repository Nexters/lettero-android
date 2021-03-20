package com.nexters.lettero.presentation.mypage.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.nexters.lettero.R
import com.nexters.lettero.data.datasource.local.SharedPreferenceHelper
import com.nexters.lettero.databinding.FragmentAppSettingBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.mypage.viewmodel.SettingViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentAppSettingBinding, SettingViewModel>() {
    override val layoutRes: Int = R.layout.fragment_app_setting

    @Inject
    override lateinit var viewModel: SettingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = SettingViewModel(SharedPreferenceHelper(requireContext()))

        binding.view = this
        binding.vm = viewModel

        initView()
    }

    fun initView() {
        viewModel.isMoveToLogin.observe(
            viewLifecycleOwner,
            { if (it) findNavController().navigate(R.id.action_settingFragment_to_loginFragment) })
    }

    fun moveToWeb(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    fun moveBack(view: View) {
        findNavController().popBackStack()
    }
}

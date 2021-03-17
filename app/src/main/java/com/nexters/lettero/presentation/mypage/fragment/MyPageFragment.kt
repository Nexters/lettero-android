package com.nexters.lettero.presentation.mypage.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.nexters.lettero.R
import com.nexters.lettero.databinding.FragmentMyPageBinding
import com.nexters.lettero.presentation.base.BaseFragment
import com.nexters.lettero.presentation.main.fragment.MainFragmentDirections
import com.nexters.lettero.presentation.mypage.viewmodel.MyPageViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyPageFragment : BaseFragment<FragmentMyPageBinding, MyPageViewModel>() {
    override val layoutRes: Int = R.layout.fragment_my_page

    @Inject
    override lateinit var viewModel: MyPageViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.view = this
        binding.vm = viewModel
    }

    fun moveToAppSetting(view: View) {
        activity?.run {
            val action = MainFragmentDirections.actionMainFragmentToSettingFragment()
            findNavController(R.id.nav_host_fragment).navigate(action)
        }
    }
}

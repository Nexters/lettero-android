package com.nexters.lettero.presentation.main.activity

import com.nexters.lettero.R
import com.nexters.lettero.databinding.ActivityMainBinding
import com.nexters.lettero.presentation.base.BaseActivity
import com.nexters.lettero.presentation.base.BaseViewModel
import com.nexters.lettero.presentation.main.viewmodel.MainBaseViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainBaseViewModel>() {
    override val layoutRes: Int = R.layout.activity_main
    override var viewModel: BaseViewModel = MainBaseViewModel()
}

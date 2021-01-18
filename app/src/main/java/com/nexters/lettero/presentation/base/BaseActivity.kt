package com.nexters.lettero.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.nexters.lettero.BR

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected abstract var viewModel: BaseViewModel

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.run {
            this.lifecycleOwner = this@BaseActivity
            this.setVariable(BR.viewModel, viewModel)
        }
    }
}

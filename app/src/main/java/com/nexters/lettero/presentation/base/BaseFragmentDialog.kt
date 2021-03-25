package com.nexters.lettero.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.nexters.lettero.BR
import com.nexters.lettero.R

abstract class  BaseFragmentDialog<VB : ViewDataBinding, VM : ViewModel> : DialogFragment() {
    protected lateinit var binding: VB
    protected abstract var viewModel: ViewModel

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
        binding.lifecycleOwner = this.viewLifecycleOwner
        dialog?.window?.setBackgroundDrawable(resources.getDrawable(R.drawable.radius_11dp, null))
        return binding.root
    }
}

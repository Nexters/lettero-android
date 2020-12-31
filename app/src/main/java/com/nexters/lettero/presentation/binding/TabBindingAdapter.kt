package com.nexters.lettero.presentation.binding

import androidx.databinding.BindingAdapter
import com.google.android.material.tabs.TabLayout

@BindingAdapter("onTabSelectedListener")
fun TabLayout.bindOnTabSelectedListener(listener: TabLayout.OnTabSelectedListener) {
    addOnTabSelectedListener(listener)
}
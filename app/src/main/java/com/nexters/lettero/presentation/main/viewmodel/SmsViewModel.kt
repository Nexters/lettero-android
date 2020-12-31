package com.nexters.lettero.presentation.main.viewmodel

import androidx.databinding.ObservableArrayList
import com.google.android.material.tabs.TabLayout
import com.nexters.lettero.domain.model.SMS
import com.nexters.lettero.presentation.base.ViewModel

class SmsViewModel : ViewModel {
    private val inBoxTabPosition = 0
    private val outBoxTabPosition = 1

    val smsItems = ObservableArrayList<SMS>().apply {
        val items = listOf(
            SMS("원일준", ""),
            SMS("차서현", ""),
            SMS("이상윤", ""),
            SMS("박나래", ""),
            SMS("박주리", ""),
            SMS("이송미", ""),
            SMS("박영환", "")
        )

        addAll(items)
    }

    val onTabSelectedListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabReselected(tab: TabLayout.Tab?) {}
        override fun onTabUnselected(tab: TabLayout.Tab?) {}
        override fun onTabSelected(tab: TabLayout.Tab?) {
            tab?.run {
                when (position) {
                    inBoxTabPosition -> {
                    }
                    outBoxTabPosition -> {
                    }
                }
            }
        }
    }
}
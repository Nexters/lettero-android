package com.nexters.lettero.presentation.main.viewmodel

import androidx.databinding.ObservableArrayList
import com.google.android.material.tabs.TabLayout
import com.nexters.lettero.domain.model.Message
import com.nexters.lettero.presentation.base.ViewModel

class HomeViewModel : ViewModel {
    private val inBoxTabPosition = 0
    private val outBoxTabPosition = 1

    val messageItems = ObservableArrayList<Message>().apply {
        val items = listOf(
            Message("원일준", ""),
            Message("차서현", ""),
            Message("이상윤", ""),
            Message("박나래", ""),
            Message("박주리", ""),
            Message("이송미", ""),
            Message("박영환", "")
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
package com.nexters.lettero.presentation.binding

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.nexters.lettero.domain.model.SMS
import com.nexters.lettero.presentation.decoration.RecyclerItemDecoration
import com.nexters.lettero.presentation.main.adapter.SmsRecyclerViewAdapter

@BindingAdapter("items")
fun RecyclerView.bindItems(items: ObservableArrayList<SMS>) {
    addItemDecoration(RecyclerItemDecoration(6, 0))

    val adapter = adapter as? SmsRecyclerViewAdapter
        ?: SmsRecyclerViewAdapter().apply {
            setHasStableIds(true)
            adapter = this
        }

    adapter.diff(items)
}

package com.nexters.lettero.presentation.binding

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.nexters.lettero.domain.model.Message
import com.nexters.lettero.presentation.decoration.RecyclerItemDecoration
import com.nexters.lettero.presentation.main.adapter.MessageRecyclerViewAdapter

@BindingAdapter("items")
fun RecyclerView.bindItems(items: ObservableArrayList<Message>) {
    addItemDecoration(RecyclerItemDecoration(6, 0))

    val adapter = adapter as? MessageRecyclerViewAdapter
        ?: MessageRecyclerViewAdapter().apply {
            setHasStableIds(true)
            adapter = this
        }

    adapter.diff(items)
}

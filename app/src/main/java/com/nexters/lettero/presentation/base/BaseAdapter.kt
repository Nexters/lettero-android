package com.nexters.lettero.presentation.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nexters.lettero.presentation.util.DiffCallback

abstract class BaseAdapter<T : Any> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    protected val items = mutableListOf<T>()

    override fun getItemCount() = items.size

    fun diff(newItems: List<T>) {
        val diffCallback = DiffCallback(items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.clear()
        items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this@BaseAdapter)
    }
}

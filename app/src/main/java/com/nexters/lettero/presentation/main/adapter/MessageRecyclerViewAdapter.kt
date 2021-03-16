package com.nexters.lettero.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nexters.lettero.BR
import com.nexters.lettero.databinding.ItemRecyclerMessageBinding
import com.nexters.lettero.domain.model.Message
import com.nexters.lettero.presentation.base.BaseAdapter

class MessageRecyclerViewAdapter : BaseAdapter<Message>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemRecyclerMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MessageViewHolder -> holder.bind(items[position])
        }
    }

    inner class MessageViewHolder(private val binding: ItemRecyclerMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Message) {
            binding.setVariable(BR.message, item)
        }
    }
}
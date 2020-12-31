package com.nexters.lettero.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nexters.lettero.BR
import com.nexters.lettero.databinding.ItemRecyclerSmsBinding
import com.nexters.lettero.domain.model.SMS
import com.nexters.lettero.presentation.base.BaseAdapter

class SmsRecyclerViewAdapter : BaseAdapter<SMS>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemRecyclerSmsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SmsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SmsViewHolder -> holder.bind(items[position])
        }
    }

    inner class SmsViewHolder(private val binding: ItemRecyclerSmsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SMS) {
            binding.setVariable(BR.sms, item)
        }
    }
}
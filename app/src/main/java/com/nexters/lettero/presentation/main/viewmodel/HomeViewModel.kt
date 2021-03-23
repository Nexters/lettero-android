package com.nexters.lettero.presentation.main.viewmodel

import androidx.databinding.ObservableArrayList
import com.google.android.material.tabs.TabLayout
import com.nexters.lettero.data.mapper.ReceiveMessageMapper
import com.nexters.lettero.data.mapper.SendMessageMapper
import com.nexters.lettero.domain.interactor.GetReceiveMessagesUseCase
import com.nexters.lettero.domain.interactor.GetSendMessagesUseCase
import com.nexters.lettero.domain.model.Message
import com.nexters.lettero.presentation.base.ViewModel

class HomeViewModel(
    private val getReceiveMessagesUseCase: GetReceiveMessagesUseCase,
    private val getSendMessagesUseCase: GetSendMessagesUseCase
) : ViewModel {
    private val inBoxTabPosition = 0
    private val outBoxTabPosition = 1

    private val receiveMessages = mutableListOf<Message>()
    private val sendMessages = mutableListOf<Message>()

    val messageItems = ObservableArrayList<Message>()

    val onTabSelectedListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabReselected(tab: TabLayout.Tab?) {}
        override fun onTabUnselected(tab: TabLayout.Tab?) {}
        override fun onTabSelected(tab: TabLayout.Tab?) {
            tab?.run {
                when (position) {
                    inBoxTabPosition -> {
                        messageItems.clear()
                        messageItems.addAll(receiveMessages)
                    }
                    outBoxTabPosition -> {
                        messageItems.clear()
                        messageItems.addAll(sendMessages)
                    }
                    else -> {
                    }
                }
            }
        }
    }

    init {
        getReceiveMessagesUseCase.buildUseCase(Unit).subscribe(
            { messages -> receiveMessages.addAll(messages.map(ReceiveMessageMapper::toDomain)) },
            { e -> }
        )

        getSendMessagesUseCase.buildUseCase(Unit).subscribe(
            { messages -> sendMessages.addAll(messages.map(SendMessageMapper::toDomain)) },
            { e -> }
        )
    }
}

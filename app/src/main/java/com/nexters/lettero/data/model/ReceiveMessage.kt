package com.nexters.lettero.data.model

data class ReceiveMessage(
    val messageId: Long,
    val text: String,
    val anonymous: Boolean,
    val senderPhoneNumber: String,
    val receiveTimestamp: Long
)

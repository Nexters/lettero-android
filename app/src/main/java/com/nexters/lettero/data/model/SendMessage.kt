package com.nexters.lettero.data.model

data class SendMessage(
    val messageId: Long,
    val text: String,
    val receiverPhoneNumber: String,
    val sendTimestamp: Long
)

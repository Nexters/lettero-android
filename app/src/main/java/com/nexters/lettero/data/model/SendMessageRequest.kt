package com.nexters.lettero.data.model

import com.google.gson.annotations.SerializedName

data class SendMessageRequest(
    @SerializedName("text")
    val text: String,
    @SerializedName("anonymous")
    val anonymous: Boolean,
    @SerializedName("receiverPhoneNumbers")
    val receiverPhoneNumbers: Array<String>
)
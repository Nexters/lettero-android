package com.nexters.lettero.data.model

import com.google.gson.annotations.SerializedName

data class SendMessageResponse (
    @SerializedName("messageId")
    val messageId:Long,
    @SerializedName("text")
    val text: String,
    @SerializedName("anonymous")
    val anonymous: Boolean,
    @SerializedName("sendTimestamp")
    val sendTimestamp: Long,
    @SerializedName("receiverInfos")
    val receiverInfos: Array<ReceiverInfos>
)
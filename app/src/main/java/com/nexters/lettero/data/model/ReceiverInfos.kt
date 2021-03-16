package com.nexters.lettero.data.model

import com.google.gson.annotations.SerializedName

data class ReceiverInfos (
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("deliveryPlatforms")
    val deliveryPlatforms: String
)
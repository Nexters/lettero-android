package com.nexters.lettero.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("userId")
    val userId: Long,
    @SerializedName("nickName")
    val nickName:String,
    @SerializedName("thumbnail")
    val thumbnail:String,
    @SerializedName("requiredPhoneNumber")
    val requiredPhoneNumber: Boolean,
    @SerializedName("requiredFirebaseToken")
    val requiredFirebaseToken: Boolean
)
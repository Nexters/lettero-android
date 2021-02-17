package com.nexters.lettero.data.model

import com.google.gson.annotations.SerializedName

data class ThumbNailResponse(
    @SerializedName("thumbnailName")
    val thumbnailName:String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl:String
)
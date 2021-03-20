package com.nexters.lettero.domain.repository

import com.google.gson.JsonObject
import com.nexters.lettero.data.model.ThumbNailResponse
import com.nexters.lettero.data.model.User
import io.reactivex.Single

interface UserRepository {

    fun getUserInfo(): Single<User>

    fun savePhoneNumber(number: JsonObject): Single<User>

    fun saveFirebaseToken(token: JsonObject): Single<User>

    fun getThumbNails(): Single<List<ThumbNailResponse>>

    fun saveKeyValue(key: String, value: String)

    fun saveKeyValue(key: String, value: Boolean)

    fun getStringValue(key: String): String?

    fun getBooleanValue(key: String, defValue: Boolean): Boolean
}
package com.nexters.lettero.data.datasource.remote

import com.google.gson.JsonObject
import com.nexters.lettero.data.model.ThumbNailResponse
import com.nexters.lettero.data.model.User
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @GET("user/me")
    fun getUserInfo(): Single<User>

    @POST("user/phone-number")
    fun savePhoneNumber(@Body uid: JsonObject): Single<User>
    
    @POST("user/firebase-token")
    fun saveFirebaseToken(@Body token: JsonObject): Single<User>

    @GET("user/thumbnails")
    fun getThumbNails(): Single<List<ThumbNailResponse>>
}
package com.nexters.lettero.data.datasource.remote

import com.nexters.lettero.data.model.ThumbNailResponse
import com.nexters.lettero.data.model.User
import io.reactivex.Single
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @GET("user/me")
    fun getUserInfo(): Single<User>

    @FormUrlEncoded
    @POST("user/phone-number")
    fun savePhoneNumber(uid: String): Single<User>

    @FormUrlEncoded
    @POST("user/firebase-token")
    fun saveFirebaseToken(token: String): Single<User>

    @GET("user/thumbnails")
    fun getThumbNails(): Single<List<ThumbNailResponse>>
}
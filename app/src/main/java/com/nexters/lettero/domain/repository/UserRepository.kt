package com.nexters.lettero.domain.repository

import com.nexters.lettero.data.model.ThumbNailResponse
import com.nexters.lettero.data.model.User
import io.reactivex.Single

interface UserRepository {

    fun getUserInfo(): Single<User>

    fun savePhoneNumber(number: String): Single<User>

    fun saveFirebaseToken(token: String): Single<User>

    fun getThumbNails(): Single<List<ThumbNailResponse>>
}
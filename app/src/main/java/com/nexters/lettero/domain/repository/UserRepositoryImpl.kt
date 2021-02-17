package com.nexters.lettero.domain.repository

import com.nexters.lettero.data.datasource.remote.LetteroNetworkHelper
import com.nexters.lettero.data.datasource.remote.UserService
import com.nexters.lettero.data.model.ThumbNailResponse
import com.nexters.lettero.data.model.User
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserRepositoryImpl() : UserRepository {
    private val userService = LetteroNetworkHelper.getService(UserService::class.java)

    override fun getUserInfo(): Single<User> = userService.getUserInfo()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    override fun savePhoneNumber(number: String): Single<User> = userService.savePhoneNumber(number)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    override fun saveFirebaseToken(token: String): Single<User> =
        userService.saveFirebaseToken(token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getThumbNails(): Single<List<ThumbNailResponse>> =
        userService.getThumbNails()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}
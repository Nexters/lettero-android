package com.nexters.lettero.domain.repository

import android.content.Context
import com.google.gson.JsonObject
import com.nexters.lettero.data.datasource.local.SharedPreferenceHelper
import com.nexters.lettero.data.datasource.remote.LetteroNetworkHelper
import com.nexters.lettero.data.datasource.remote.UserService
import com.nexters.lettero.data.model.ThumbNailResponse
import com.nexters.lettero.data.model.User
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserRepositoryImpl(context: Context) : UserRepository {
    private val userService = LetteroNetworkHelper.getService(UserService::class.java)
    private val sharedPreferenceHelper: SharedPreferenceHelper = SharedPreferenceHelper(context)

    override fun getUserInfo(): Single<User> = userService.getUserInfo()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    override fun savePhoneNumber(number: JsonObject): Single<User> = userService.savePhoneNumber(number)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    override fun saveFirebaseToken(token: JsonObject): Single<User> =
        userService.saveFirebaseToken(token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getThumbNails(): Single<List<ThumbNailResponse>> =
        userService.getThumbNails()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun saveKeyValue(key: String, value: String) {
        sharedPreferenceHelper.saveKeyValue(key, value)
    }

    override fun getStringValue(key: String): String? {
        return sharedPreferenceHelper.getStringValue(key)
    }

}
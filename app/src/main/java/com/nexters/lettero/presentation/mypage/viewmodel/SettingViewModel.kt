package com.nexters.lettero.presentation.mypage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nexters.lettero.data.datasource.local.SharedPreferenceHelper
import com.nexters.lettero.presentation.base.ViewModel

class SettingViewModel() : ViewModel {
    var sharedPreferenceHelper: SharedPreferenceHelper? = null

    private val _isMoveToLogin = MutableLiveData<Boolean>(false)
    val isMoveToLogin: LiveData<Boolean> = _isMoveToLogin
    val _isReceiveNoti: MutableLiveData<Boolean> = MutableLiveData<Boolean>(getReceiveNoticeValue())

    constructor(preferenceHelper: SharedPreferenceHelper): this() {

        sharedPreferenceHelper = preferenceHelper

        _isReceiveNoti.value = getReceiveNoticeValue()
        _isReceiveNoti.observeForever {
            android.util.Log.d("setting view model", it.toString())
            setReceiveNoticeValue(it)
        }
    }

    fun getReceiveNoticeValue(): Boolean {
        sharedPreferenceHelper?.let {
            return it.isReceiveNotice()
        }

        return true
    }

    fun setReceiveNoticeValue(value: Boolean) {
        sharedPreferenceHelper?.setReceiveNotice(value)
    }

    fun logout() {
        sharedPreferenceHelper?.let {
            it.setAutoLogin(false)
            _isMoveToLogin.value = true
        }
    }

    fun exit() {
        _isMoveToLogin.value = true
    }
}

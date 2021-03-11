package com.nexters.lettero.presentation.mypage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nexters.lettero.data.datasource.local.SharedPreferenceHelper
import com.nexters.lettero.presentation.base.ViewModel

class SettingViewModel : ViewModel {
    var sharedPreferenceHelper: SharedPreferenceHelper? = null

    private val _isMoveToLogin = MutableLiveData<Boolean>(false)
    val isMoveToLogin: LiveData<Boolean> = _isMoveToLogin

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

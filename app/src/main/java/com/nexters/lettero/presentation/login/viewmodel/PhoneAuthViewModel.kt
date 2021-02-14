package com.nexters.lettero.presentation.login.viewmodel

import android.content.Intent
import android.os.CountDownTimer
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.credentials.Credential
import com.nexters.lettero.presentation.base.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class PhoneAuthViewModel : ViewModel {
    val phoneNumber = MutableLiveData<String>()
    val rtnNumber = MutableLiveData<String>()
    val authTimer = MutableLiveData<String>()

    private val _resultAuthOk = MutableLiveData<Boolean>()
    val resultAuthOk:LiveData<Boolean> = _resultAuthOk

    val SEC_INTERVAL = 1000L
    val MAX_SECOND = SEC_INTERVAL * 60 * 3 // 3분

    val countDownTimer = object : CountDownTimer(MAX_SECOND, SEC_INTERVAL) {
        override fun onFinish() {
            authTimer.value = "00:00"
        }

        override fun onTick(millisUntilFinished: Long) {
            authTimer.value = SimpleDateFormat("mm:ss").format(Date(millisUntilFinished))
        }
    }

    init {
        phoneNumber.value = ""
        authTimer.value = ""
        rtnNumber.value = ""
    }

    fun setPhoneNumber(intent: Intent?) {
        intent?.let {
            val credential: Credential? = it.getParcelableExtra(Credential.EXTRA_KEY)
            val number = credential?.id?.replace("+82", "0")

            phoneNumber.value = number
        }
    }

    // TODO : 휴대폰 번호 인증 요청
    fun requestPhoneNumberAuth(view: View) {
        phoneNumber.value?.let {
            if (it.isEmpty()) return@let
            countDownTimer.start()
        }
    }

    // TODO : 휴대폰 인증 완료
    fun confirmRtnNumber(view: View) {
        rtnNumber.value?.let {
            if (it.isEmpty()) return@let

            _resultAuthOk.value = true
        }
    }
}



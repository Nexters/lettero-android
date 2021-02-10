package com.nexters.lettero.presentation.login.viewmodel

import android.os.CountDownTimer
import androidx.databinding.ObservableField
import com.nexters.lettero.presentation.base.ViewModel

class PhoneAuthViewModel : ViewModel {
    val phoneNumber = ObservableField<String>()
    val confrimNumber = ObservableField<String>()
    val authTimer = ObservableField<String>()
    val SEC_INTERVAL = 1000L
    val MAX_SECOND = SEC_INTERVAL * 60 * 3 // 3분

    val countDownTimer = object : CountDownTimer(MAX_SECOND, SEC_INTERVAL) {
        override fun onFinish() {
            TODO("Not yet implemented")
        }

        override fun onTick(millisUntilFinished: Long) {
            TODO("Not yet implemented")
        }

    }

    init {
        authTimer.set("")
        confrimNumber.set("")
    }

    // TODO : 휴대폰 번호 인증 요청
    fun requestPhoneNumberAuth() {

    }

    // TODO : 휴대폰 인증 완료
    fun confirmPhoneNumber() {

    }
}

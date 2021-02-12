package com.nexters.lettero.presentation.login.viewmodel

import android.os.CountDownTimer
import android.view.View
import androidx.databinding.ObservableField
import androidx.navigation.NavController
import com.nexters.lettero.R
import com.nexters.lettero.presentation.base.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class PhoneAuthViewModel : ViewModel {
    val phoneNumber = ObservableField<String>()
    val rtnNumber = ObservableField<String>()
    val authTimer = ObservableField<String>()
    lateinit var navController: NavController

    val SEC_INTERVAL = 1000L
    val MAX_SECOND = SEC_INTERVAL * 60 * 3 // 3분

    val countDownTimer = object : CountDownTimer(MAX_SECOND, SEC_INTERVAL) {
        override fun onFinish() {
            authTimer.set("00:00")
        }

        override fun onTick(millisUntilFinished: Long) {
            authTimer.set(SimpleDateFormat("mm:ss").format(Date(millisUntilFinished)))
        }
    }

    init {
        phoneNumber.set("")
        authTimer.set("")
        rtnNumber.set("")
    }

    // TODO : 휴대폰 번호 인증 요청
    fun requestPhoneNumberAuth(view: View) {
        phoneNumber.get()?.let {
            if (it.isEmpty()) return@let
            countDownTimer.start()
        }
    }

    // TODO : 휴대폰 인증 완료
    fun confirmRtnNumber(view: View) {
        rtnNumber.get()?.let {
            if (it.isEmpty()) return@let

            navController.navigate(R.id.action_phoneAuthFragment_to_mainFragment)
        }
    }

    fun backLogin(view: View) {
        navController.navigate(R.id.action_phoneAuthFragment_to_loginFragment)
    }
}

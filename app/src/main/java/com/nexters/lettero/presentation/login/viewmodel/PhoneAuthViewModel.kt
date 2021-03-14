package com.nexters.lettero.presentation.login.viewmodel

import android.content.Intent
import android.os.CountDownTimer
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.credentials.Credential
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.nexters.lettero.domain.repository.UserRepositoryImpl
import com.nexters.lettero.presentation.base.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class PhoneAuthViewModel : ViewModel, PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
    val phoneNumber = MutableLiveData<String>()
    val rtnNumber = MutableLiveData<String>()
    val authTimer = MutableLiveData<String>()

    private val _resultAuthOk = MutableLiveData<Boolean>()
    val resultAuthOk: LiveData<Boolean> = _resultAuthOk

    val SEC_INTERVAL = 1000L
    val MAX_SECOND = 60 * 2L // 120초가 최대

    private val userRepository = UserRepositoryImpl()

    private var verificationId: String = ""

    val countDownTimer = object : CountDownTimer(MAX_SECOND * SEC_INTERVAL, SEC_INTERVAL) {
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
            val number = credential?.id

            phoneNumber.value = number
        }
    }

    fun doPhoneAuth() {
        rtnNumber.value = ""
        countDownTimer.start()
    }

    fun confirmRtnNumber(view: View) {
        rtnNumber.value?.let {
            if (it.isEmpty()) return@let

            val authCredential = PhoneAuthProvider.getCredential(verificationId, it)
            FirebaseAuth.getInstance().signInWithCredential(authCredential)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        _resultAuthOk.value = true
                        savePhoneNumver()
                    } else {
                        _resultAuthOk.value = false
                    }
                }
        }
    }

    override fun onVerificationCompleted(p0: PhoneAuthCredential) {
        android.util.Log.d("phone auth view model : ", "complete")
    }

    override fun onVerificationFailed(p0: FirebaseException) {
        android.util.Log.d("phone auth view model : ", p0.message.toString())
        _resultAuthOk.value = false
    }

    override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
        super.onCodeSent(p0, p1)

        android.util.Log.d("phone auth view model : ", "code sent")
        verificationId = p0
    }

    private fun savePhoneNumver() {
        userRepository.savePhoneNumber(phoneNumber.value as String)
    }
}



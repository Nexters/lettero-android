package com.nexters.lettero.presentation.login.viewmodel

import android.content.Intent
import android.os.CountDownTimer
import android.telephony.PhoneNumberUtils
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.credentials.Credential
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.gson.JsonObject
import com.nexters.lettero.R
import com.nexters.lettero.data.model.UserInfo
import com.nexters.lettero.domain.repository.UserRepository
import com.nexters.lettero.presentation.base.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class PhoneAuthViewModel(val userRepository: UserRepository) : ViewModel, PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
    val phoneNumber = MutableLiveData<String>()
    val rtnNumber = MutableLiveData<String>()
    val authTimer = MutableLiveData<String>()

    private val _resultAuthOk = MutableLiveData<Boolean>()
    val resultAuthOk: LiveData<Boolean> = _resultAuthOk

    val SEC_INTERVAL = 1000L
    val MAX_SECOND = 60 * 2L // 120초가 최대

    private var verificationId: String = ""

    private val _message = MutableLiveData<Int?>()
    val message: LiveData<Int?> = _message

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
            //TODO : 외국 서비스를 할 시 바꿀 필요 있음
            val number = credential?.id?.replace("+82", "0")

            phoneNumber.value = number
        }
    }

    fun confirmRtnNumber(view: View) {
        rtnNumber.value?.let {
            if (it.isEmpty()) return@let

            val authCredential = PhoneAuthProvider.getCredential(verificationId, it)
            FirebaseAuth.getInstance().signInWithCredential(authCredential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        saveId(task.result?.user?.uid)
                        UserInfo.getInstance().firebaseInfo = task.result?.user
                    } else {
                        _message.value = R.string.phone_auth_check_code
                        _resultAuthOk.value = false
                    }
                }
        }
    }

    override fun onVerificationCompleted(p0: PhoneAuthCredential) {
        android.util.Log.d("phone auth view model : ", "complete")
    }

    override fun onVerificationFailed(p0: FirebaseException) {
        android.util.Log.d("phone auth view model : ", "error : " + p0.message.toString())
        _resultAuthOk.value = false
        _message.value = R.string.phone_auth_check_number
    }

    override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
        super.onCodeSent(p0, p1)
        android.util.Log.d("phone auth view model : ", "code sent")

        _message.value = R.string.phone_auth_send_code
        rtnNumber.value = ""
        countDownTimer.start()
        verificationId = p0
    }

    private fun saveId(id: String?) {
        id?.let { uid ->
            val sendObj: JsonObject = JsonObject()
            sendObj.addProperty("uid", uid)
            userRepository.savePhoneNumber(sendObj).subscribe({ user ->
                UserInfo.getInstance().user = user
                _resultAuthOk.value = true
            }, { err ->
                _message.value = R.string.common_err
                _resultAuthOk.value = false
            })
        }
    }

    public fun parsePhoneE164Number(number: String, countryCode: Locale): String? {
        var e164Num: String? = null

        try {
            e164Num = PhoneNumberUtils.formatNumberToE164(number, countryCode.country)
        } catch (e: Exception) {
            e164Num = null
        }

        if (e164Num == null)
            _message.value = R.string.phone_auth_check_number

        return e164Num
    }
}



package com.nexters.lettero.presentation.sms.viewmodel

import android.text.Editable
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.nexters.lettero.presentation.base.ViewModel

class SendSmsViewModel : ViewModel {
    val senderName = MutableLiveData<String>()
    val isAnonymous = MutableLiveData<Boolean>()

    val receiverNumber = MutableLiveData<String>()
    val cntMsg = MutableLiveData<Int>()
    val sendMsg = MutableLiveData<String>()
    val sendResult = MutableLiveData<Boolean>()

    val TEXT_MAX_LENGTH = 100

    init {
        //TODO : 실 사용자와 연결
        initDefaultValue()
    }

    fun setMsgChangeResult(edtResult: Editable?) {
        edtResult?.let {
            cntMsg.value = it.length
        }
    }

    fun sendSms(view: View) {
        if ((senderName.value as? String).isNullOrEmpty()) return
        if ((receiverNumber.value as? String).isNullOrEmpty()) return
        if ((sendMsg.value as? String).isNullOrEmpty()) return

        //TODO : 네트워크 처리

        sendResult.value = true
    }

    fun initDefaultValue() {
        senderName.value = "aaaa"
        receiverNumber.value = ""
        sendMsg.value = ""
        cntMsg.value = 0

        isAnonymous.value = false
        sendResult.value = false
    }

}

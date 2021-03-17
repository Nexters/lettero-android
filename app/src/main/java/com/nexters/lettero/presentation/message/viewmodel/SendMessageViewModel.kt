package com.nexters.lettero.presentation.message.viewmodel

import android.text.Editable
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.nexters.lettero.data.model.SendMessageRequest
import com.nexters.lettero.data.model.UserInfo
import com.nexters.lettero.domain.repository.MessageRepository
import com.nexters.lettero.presentation.base.ViewModel

class SendMessageViewModel : ViewModel {
    val senderName = MutableLiveData<String>()
    val isAnonymous = MutableLiveData<Boolean>()

    val receiverNumber = MutableLiveData<String>()
    val cntMsg = MutableLiveData<Int>()
    val sendMsg = MutableLiveData<String>()
    val sendResult = MutableLiveData<Boolean?>()

    private val msgRepository: MessageRepository = MessageRepository()

    val TEXT_MAX_LENGTH = 100

    init {
        initDefaultValue()
    }

    fun setMsgChangeResult(edtResult: Editable?) {
        edtResult?.let {
            cntMsg.value = it.length
        }
    }

    fun sendMessage(view: View) {
        if ((senderName.value as? String).isNullOrEmpty()) return
        if ((receiverNumber.value as? String).isNullOrEmpty()) return
        if ((sendMsg.value as? String).isNullOrEmpty()) return

        val msg = SendMessageRequest(
            sendMsg.value!!,
            isAnonymous.value!!,
            arrayOf(receiverNumber.value!!)
        )

        msgRepository.sendMessage(msg).subscribe { result, err ->
            if(err != null) {
                Log.d("SendMessageViewModel", err.localizedMessage)
                sendResult.value = false

                err.printStackTrace()
                return@subscribe
            }

            sendResult.value = true
        }

        sendResult.postValue(null)
    }

    fun initDefaultValue() {
        senderName.value = UserInfo.getInstance().user?.nickName
        receiverNumber.value = ""
        sendMsg.value = ""
        cntMsg.value = 0

        isAnonymous.value = false
        sendResult.value = null
    }

}

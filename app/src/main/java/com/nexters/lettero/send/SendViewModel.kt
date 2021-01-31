package com.nexters.lettero.send

import android.view.View
import androidx.databinding.ObservableField
import com.nexters.lettero.R

class SendViewModel(val sendActivity: SendActivity) {
    var msgCnt: ObservableField<Int> = ObservableField<Int>()
    val TEXT_MAX_LENGTH = 100
    val senderName = ObservableField<String>()
    var receiverNumber: String = "010-0000-0000"

    init {
        msgCnt.set(0)
        senderName.set("홍길동") //사용자 정보 연결 후 변경 예정
    }


    fun sendMessage(view: View) {

    }

    fun startPrivateSettingDialog(view: View) {
        sendActivity.startPrivateDialog()
    }

    fun setMessageCnt(count: Int) {
        msgCnt.set(count)
    }

    fun setSenderName(isPrivate: Boolean) {
        if(isPrivate) {
            senderName.set(sendActivity.getString(R.string.sender_name_hide))
        } else {
            senderName.set("홍길동") //사용자 정보 연결 후 변경 예정
        }
    }
}
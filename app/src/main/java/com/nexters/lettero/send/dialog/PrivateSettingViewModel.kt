package com.nexters.lettero.send.dialog

import androidx.databinding.ObservableField

class PrivateSettingViewModel {
    val isPrivate = ObservableField<Boolean>()

    init {
        isPrivate.set(false)
    }

    fun setPrivateSender(isPrivateSender: Boolean){
        isPrivate.set(isPrivateSender)
    }
}
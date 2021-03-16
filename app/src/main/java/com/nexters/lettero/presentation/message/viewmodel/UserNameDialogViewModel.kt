package com.nexters.lettero.presentation.message.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nexters.lettero.presentation.base.ViewModel

class UserNameDialogViewModel : ViewModel {
    private val _isPrivateName = MutableLiveData<Boolean>()
    val isPrivateName:LiveData<Boolean> = _isPrivateName

    init {
        _isPrivateName.value = false
    }

    fun setPrivate(isPrivate: Boolean) {
        _isPrivateName.value = isPrivate
    }
}
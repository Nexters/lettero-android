package com.nexters.lettero.presentation.mypage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nexters.lettero.data.model.User
import com.nexters.lettero.domain.repository.UserRepositoryImpl
import com.nexters.lettero.presentation.base.ViewModel

class MyPageViewModel : ViewModel {
    val userRepository = UserRepositoryImpl()

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>  = _name

    private val _phoneNumber = MutableLiveData<String>()
    val phoneNumber:LiveData<String> = _phoneNumber

    private val _thumbNailUrl = MutableLiveData<String>()
    val thumbNailUrl:LiveData<String> = _thumbNailUrl

    init {
        userRepository.getUserInfo().subscribe({
            user: User?, t2: Throwable? ->
            user?.let {
                _name.value = user.nickName
                _phoneNumber.value = user.userId.toString()
                _thumbNailUrl.value = user.thumbnail
            }
            t2?.let {
                _name.value = ""
                _phoneNumber.value = ""
            }
        })
    }


}

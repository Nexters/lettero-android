package com.nexters.lettero.presentation.mypage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kakao.sdk.user.UserApiClient
import com.nexters.lettero.domain.interactor.KakaoTokenUseCase
import com.nexters.lettero.domain.repository.UserRepository
import com.nexters.lettero.presentation.base.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class SettingViewModel(val userRepository: UserRepository, val kakaoTokenUseCase: KakaoTokenUseCase) : ViewModel {
    private val _isMoveToLogin = MutableLiveData<Boolean>(false)
    val isMoveToLogin: LiveData<Boolean> = _isMoveToLogin

    val _isReceiveNoti: MutableLiveData<Boolean> = MutableLiveData<Boolean>(getReceiveNoticeValue())

    private val disposable = CompositeDisposable()

    init {
        _isReceiveNoti.value = getReceiveNoticeValue()
        _isReceiveNoti.observeForever { setReceiveNoticeValue(it) }
    }

    fun getReceiveNoticeValue(): Boolean {
        return userRepository.getBooleanValue("isReceiveNotice", true)
    }

    fun setReceiveNoticeValue(value: Boolean) {
        userRepository.saveKeyValue("isReceiveNotice", value)
    }

    fun logout() {
        kakaoTokenUseCase.logout().subscribe().addTo(disposable)

        _isMoveToLogin.value = true
    }

    fun exit() {
        kakaoTokenUseCase.logout().subscribe().addTo(disposable)
        _isMoveToLogin.value = true
    }
}

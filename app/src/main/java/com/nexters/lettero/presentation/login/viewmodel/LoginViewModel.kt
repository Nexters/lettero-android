package com.nexters.lettero.presentation.login.viewmodel

import androidx.lifecycle.MutableLiveData
import com.nexters.lettero.data.model.UserInfo
import com.nexters.lettero.domain.interactor.KakaoLoginUseCase
import com.nexters.lettero.domain.repository.UserRepository
import com.nexters.lettero.domain.repository.UserRepositoryImpl
import com.nexters.lettero.presentation.base.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class LoginViewModel(val kakaoLoginUseCase: KakaoLoginUseCase, val userRepo: UserRepository) : ViewModel {
    val disposable = CompositeDisposable()
    val loginResult: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val isNeedPhoneAuth: MutableLiveData<Boolean?> = MutableLiveData(null)

    fun kakaoLogin() {
        kakaoLoginUseCase.buildUseCase(Unit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ token ->
                loginResult.value = token?.let { true } ?: false

                UserInfo.getInstance().accessToken = token.accessToken
                UserInfo.getInstance().refershToken = token.refreshToken

                saveToken("accessToken", token.accessToken)
                saveToken("refreshToken", token.refreshToken)
            }, { error ->
                loginResult.value = false
            })
            .addTo(disposable)
    }

    fun requestUserMe() {
        userRepo.getUserInfo().subscribe { user, err ->

            if(err != null) {
                loginResult.value = false
                err.printStackTrace()
                return@subscribe
            }

            UserInfo.getInstance().user = user
            if(user.requiredPhoneNumber) {
                isNeedPhoneAuth.value = true
            } else {
                isNeedPhoneAuth.value = false
            }
        }
    }

    private fun saveToken(key:String, value: String) {
        userRepo.saveKeyValue(key, value)
    }
}

package com.nexters.lettero.presentation.login.viewmodel

import androidx.lifecycle.MutableLiveData
import com.nexters.lettero.domain.interactor.KakaoLoginUseCase
import com.nexters.lettero.presentation.base.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class LoginViewModel(val kakaoLoginUseCase: KakaoLoginUseCase) : ViewModel {
    val disposable = CompositeDisposable()
    val loginResult: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun kakaoLogin() {
        kakaoLoginUseCase.buildUseCase(Unit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ token ->
                loginResult.value = token?.let { true } ?: false
            }, { error ->
                loginResult.value = false
            })
            .addTo(disposable)
    }
}

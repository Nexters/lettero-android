package com.nexters.lettero.presentation.login.viewmodel

import com.nexters.lettero.domain.interactor.KakaoLoginUseCase
import com.nexters.lettero.presentation.base.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel {
    @Inject
    lateinit var kakaoLoginUseCase: KakaoLoginUseCase
    private val disposable = CompositeDisposable()

    fun kakaoLogin() {
        kakaoLoginUseCase.buildUseCase(Unit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ token ->
            }, { error ->
            })
            .addTo(disposable)
    }
}

package com.nexters.lettero.presentation.intro.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nexters.lettero.domain.interactor.KakaoTokenUseCase
import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.lifecycle.LifecycleCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class IntroViewModel(val kakaoTokenUseCase: KakaoTokenUseCase) : ViewModel, LifecycleCallback {
    val disposable = CompositeDisposable()
    val tokenResult: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    override fun apply(event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
            }
            Lifecycle.Event.ON_RESUME -> {
                kakaoTokenUseCase.buildUseCase(Unit)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ token ->
                        token?.let {
                            tokenResult.value = true
                        } ?: run {
                            tokenResult.value = false
                        }
                    }, { error ->
                        tokenResult.value = false
                    })
                    .addTo(disposable)
            }
            Lifecycle.Event.ON_DESTROY -> {
            }
        }
    }
}

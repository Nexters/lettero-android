package com.nexters.lettero.domain.interactor

import android.app.Application
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.auth.rx
import com.nexters.lettero.domain.interactor.base.BaseUseCase
import io.reactivex.Single

class KakaoLoginUseCase(private val app: Application) : BaseUseCase<Single<OAuthToken>, Unit> {

    override fun buildUseCase(params: Unit) =
        Single.just(LoginClient.instance.isKakaoTalkLoginAvailable(app.applicationContext))
            .flatMap { available ->
                if (available) LoginClient.rx.loginWithKakaoTalk(app.applicationContext)
                else LoginClient.rx.loginWithKakaoAccount(app.applicationContext)
            }
}

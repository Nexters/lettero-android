package com.nexters.lettero.domain.interactor

import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.AccessTokenInfo
import com.kakao.sdk.user.rx
import com.nexters.lettero.domain.interactor.base.BaseUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class KakaoTokenUseCase : BaseUseCase<Single<AccessTokenInfo>, Unit> {

    override fun buildUseCase(params: Unit) =
        UserApiClient.rx.accessTokenInfo()

    fun logout() = UserApiClient.rx.logout().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

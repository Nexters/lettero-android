package com.nexters.lettero.domain.interactor

import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.AccessTokenInfo
import com.kakao.sdk.user.rx
import com.nexters.lettero.domain.interactor.base.BaseUseCase
import io.reactivex.Single

class KakaoTokenUseCase : BaseUseCase<Single<AccessTokenInfo>, Unit> {

    override fun buildUseCase(params: Unit) =
        UserApiClient.rx.accessTokenInfo()
}

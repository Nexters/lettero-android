package com.nexters.lettero.app

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.nexters.lettero.R

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this@GlobalApplication, getString(R.string.kakao_native_app_key))
    }
}

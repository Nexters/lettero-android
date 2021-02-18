package com.nexters.lettero.domain.di

import android.app.Application
import com.nexters.lettero.domain.interactor.KakaoLoginUseCase
import com.nexters.lettero.domain.interactor.KakaoTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object UseCaseModule {

    @Provides
    fun provideKakaoLoginUseCase(app: Application) = KakaoLoginUseCase(app)

    @Provides
    fun provideKakaoTokenUseCase() = KakaoTokenUseCase()
}
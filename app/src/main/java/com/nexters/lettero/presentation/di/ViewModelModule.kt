package com.nexters.lettero.presentation.di

import com.nexters.lettero.domain.interactor.KakaoLoginUseCase
import com.nexters.lettero.domain.interactor.KakaoTokenUseCase
import com.nexters.lettero.presentation.intro.viewmodel.IntroViewModel
import com.nexters.lettero.presentation.login.viewmodel.LoginViewModel
import com.nexters.lettero.presentation.main.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ViewModelModule {

    @Provides
    fun provideMainViewModel() = MainViewModel()

    @Provides
    fun provideIntroViewModel(kakaoTokenUseCase: KakaoTokenUseCase) =
        IntroViewModel(kakaoTokenUseCase)

    @Provides
    fun provideLoginViewModel(kakaoLoginUseCase: KakaoLoginUseCase) =
        LoginViewModel(kakaoLoginUseCase)
}

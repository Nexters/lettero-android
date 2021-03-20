package com.nexters.lettero.presentation.di

import com.nexters.lettero.domain.interactor.KakaoLoginUseCase
import com.nexters.lettero.domain.interactor.KakaoTokenUseCase
import com.nexters.lettero.domain.repository.UserRepository
import com.nexters.lettero.presentation.intro.viewmodel.IntroViewModel
import com.nexters.lettero.presentation.login.viewmodel.LoginViewModel
import com.nexters.lettero.presentation.login.viewmodel.PhoneAuthViewModel
import com.nexters.lettero.presentation.main.viewmodel.MainViewModel
import com.nexters.lettero.presentation.mypage.viewmodel.MyPageViewModel
import com.nexters.lettero.presentation.mypage.viewmodel.SettingViewModel
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
    fun provideIntroViewModel(
        kakaoTokenUseCase: KakaoTokenUseCase,
        userRepository: UserRepository
    ) =
        IntroViewModel(kakaoTokenUseCase, userRepository)

    @Provides
    fun provideLoginViewModel(
        kakaoLoginUseCase: KakaoLoginUseCase,
        userRepository: UserRepository
    ) =
        LoginViewModel(kakaoLoginUseCase, userRepository)

    @Provides
    fun providePhoneAuthViewModel(userRepository: UserRepository) =
        PhoneAuthViewModel(userRepository)

    @Provides
    fun provideMyPageViewModel(userRepository: UserRepository) = MyPageViewModel(userRepository)

    @Provides
    fun provideSettingViewModel(userRepository: UserRepository, kakaoTokenUseCase: KakaoTokenUseCase) = SettingViewModel(userRepository, kakaoTokenUseCase)
}

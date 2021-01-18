package com.nexters.lettero.presentation.di

import com.nexters.lettero.presentation.base.ViewModel
import com.nexters.lettero.presentation.intro.viewmodel.IntroViewModel
import com.nexters.lettero.presentation.login.viewmodel.LoginViewModel
import com.nexters.lettero.presentation.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Qualifier

@Module
@InstallIn(FragmentComponent::class)
abstract class ViewModelModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Main

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Intro

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Login

    @Main
    @Binds
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Intro
    @Binds
    abstract fun bindIntroViewModel(introViewModel: IntroViewModel): ViewModel

    @Login
    @Binds
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel
}
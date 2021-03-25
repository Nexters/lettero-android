package com.nexters.lettero.domain.di

import android.app.Application
import android.content.Context
import com.nexters.lettero.domain.interactor.GetReceiveMessagesUseCase
import com.nexters.lettero.domain.interactor.GetSendMessagesUseCase
import com.nexters.lettero.domain.interactor.KakaoLoginUseCase
import com.nexters.lettero.domain.interactor.KakaoTokenUseCase
import com.nexters.lettero.domain.repository.MessageRepository
import com.nexters.lettero.domain.repository.UserRepository
import com.nexters.lettero.domain.repository.UserRepositoryImpl
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

    @Provides
    fun provideGetReceiveMessageUseCase(messageRepository: MessageRepository) =
        GetReceiveMessagesUseCase(messageRepository)

    @Provides
    fun provideGetSendMessageUseCase(messageRepository: MessageRepository) =
        GetSendMessagesUseCase(messageRepository)

    @Provides
    fun provideUserRepository(app: Application) =
        UserRepositoryImpl(app.applicationContext) as UserRepository
}

package com.nexters.lettero.domain.di

import com.nexters.lettero.domain.repository.MessageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

// TODO 필요한 분리 작업 : Repository interface -> Domain Layer, Repository implementation -> Data Layer
@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    fun provideMessageRepository() = MessageRepository()
}

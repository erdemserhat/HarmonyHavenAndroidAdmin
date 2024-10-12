package com.erdemserhat.harmonyadmin.di

import com.erdemserhat.harmonyadmin.api.NotificationApiService
import com.erdemserhat.harmonyadmin.usecase.NotificationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationUseCaseModule {

    @Provides
    @Singleton
    fun provideNotificationUseCase(notificationApiService: NotificationApiService): NotificationUseCase {
        return NotificationUseCase(notificationApiService)
    }
}
package com.erdemserhat.harmonyadmin.di

import com.erdemserhat.harmonyadmin.api.NotificationApiService
import com.erdemserhat.harmonyadmin.model.NotificationSpecificDto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationApiModule {

    @Provides
    @Singleton
    fun provideNotificationApiService(retrofit: Retrofit): NotificationApiService {
        return retrofit.create(NotificationApiService::class.java)
    }



}
package com.erdemserhat.harmonyadmin.di

import com.erdemserhat.harmonyadmin.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://212.87.233.40:5000/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        jwtInterceptor: JwtInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES) // Sets the timeout for connecting to the server
            .readTimeout(45, TimeUnit.SECONDS) // Sets the timeout for reading data from the server
            .writeTimeout(30, TimeUnit.SECONDS) // Sets the timeout for writing data to the server
            .addInterceptor(jwtInterceptor) // Adds the JWT interceptor for authentication
            .build()
    }


}
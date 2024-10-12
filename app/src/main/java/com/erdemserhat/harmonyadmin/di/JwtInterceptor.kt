package com.erdemserhat.harmonyadmin.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


// for
class JwtInterceptor @Inject constructor(

) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {


        val jwtToken = AdminCredentials.JWT


        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $jwtToken")
            .build()

        return chain.proceed(request)

    }
}
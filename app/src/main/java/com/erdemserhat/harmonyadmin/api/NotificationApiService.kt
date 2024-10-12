package com.erdemserhat.harmonyadmin.api

import com.erdemserhat.harmonyadmin.model.NotificationDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface NotificationApiService {

    @POST("notification/send-general")
    suspend fun pushEveryone(@Body notificationDto: NotificationDto): Response<Unit>

}
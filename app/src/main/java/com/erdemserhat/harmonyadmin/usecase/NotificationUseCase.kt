package com.erdemserhat.harmonyadmin.usecase

import android.util.Log
import com.erdemserhat.harmonyadmin.api.NotificationApiService
import com.erdemserhat.harmonyadmin.model.NotificationDto
import com.erdemserhat.harmonyadmin.model.NotificationSpecificDto
import com.google.gson.Gson
import javax.inject.Inject

class NotificationUseCase @Inject constructor(
    private val notificationApiService: NotificationApiService
) {
    suspend fun pushNotification(notificationDto: NotificationDto) {
        try {
            val response = notificationApiService.pushEveryone(notificationDto)
            if (response.isSuccessful) {
                Log.d("NOTIFICIATON-USECASE-LOGS", "NotificationUseCase: 1")

            } else {
                val errorBodyJson = response.message()
                Log.d("NOTIFICIATON-USECASE-LOGS", "NotificationUseCase:$errorBodyJson")
            }


        } catch (e: NotificationException) {
            Log.d("NOTIFICIATON-USECASE-LOGS", "NotificationUseCase: 2")
        }

    }

    suspend fun pushNotificationSpecific(notificationSpecificDto: NotificationSpecificDto) {
        try {
            val response = notificationApiService.pushSpecific(notificationSpecificDto)
            if (response.isSuccessful) {
                Log.d("NOTIFICIATON-USECASE-LOGS", "NotificationUseCase: 1")

            } else {
                val errorBodyJson = response.message()
                Log.d("NOTIFICIATON-USECASE-LOGS", "NotificationUseCase:$errorBodyJson")
            }


        } catch (e: NotificationException) {
            Log.d("NOTIFICIATON-USECASE-LOGS", "NotificationUseCase: 2")
        }

    }

}
package com.erdemserhat.harmonyadmin.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erdemserhat.harmonyadmin.model.NotificationDto
import com.erdemserhat.harmonyadmin.model.NotificationSpecificDto
import com.erdemserhat.harmonyadmin.usecase.NotificationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    private val notificationUseCase: NotificationUseCase
) : ViewModel() {

    fun sendNotification(notificationDto: NotificationDto) {
        viewModelScope.launch {
            try {
                notificationUseCase.pushNotification(notificationDto)

            }catch (e:Exception){
                Log.d("NOTIFICATION-VIEWMODEL-LOGS", e.message.toString())
            }
        }


    }

    fun sendNotificationSpecific(notificationSpecificDto: NotificationSpecificDto) {
        viewModelScope.launch {
            try {
                notificationUseCase.pushNotificationSpecific(notificationSpecificDto)

            }catch (e:Exception){
                Log.d("NOTIFICATION-VIEWMODEL-LOGS", e.message.toString())
            }
        }


    }
}
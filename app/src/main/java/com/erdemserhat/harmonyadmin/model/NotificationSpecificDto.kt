package com.erdemserhat.harmonyadmin.model

import kotlinx.serialization.Serializable


@Serializable
data class NotificationSpecificDto(
    val email:String,
    val notification: NotificationDto

)
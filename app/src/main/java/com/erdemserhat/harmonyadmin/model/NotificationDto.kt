package com.erdemserhat.harmonyadmin.model

import kotlinx.serialization.Serializable

@Serializable
class NotificationDto(
    val title: String,
    val body: String,
    val image: String = "",
    val screen: String = ""
)
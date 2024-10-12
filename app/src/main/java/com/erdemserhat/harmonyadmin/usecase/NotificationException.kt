package com.erdemserhat.harmonyadmin.usecase

class NotificationException(
    override val message: String,
) : Exception(message)
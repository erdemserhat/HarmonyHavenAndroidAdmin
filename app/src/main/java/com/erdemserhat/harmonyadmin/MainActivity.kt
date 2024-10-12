package com.erdemserhat.harmonyadmin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erdemserhat.harmonyadmin.api.NotificationApiService
import com.erdemserhat.harmonyadmin.di.ExampleDependency
import com.erdemserhat.harmonyadmin.model.NotificationDto
import com.erdemserhat.harmonyadmin.presentation.GeneralNotificationScreen
import com.erdemserhat.harmonyadmin.ui.theme.HarmonyAdminTheme
import com.erdemserhat.harmonyadmin.usecase.NotificationUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
     lateinit var exampleDependency: ExampleDependency

     @Inject
     lateinit var notificationUseCase: NotificationUseCase

     @Inject
     lateinit var apiService: NotificationApiService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()
        setContent {
            HarmonyAdminTheme {
                GeneralNotificationScreen()
            }
        }
    }
}


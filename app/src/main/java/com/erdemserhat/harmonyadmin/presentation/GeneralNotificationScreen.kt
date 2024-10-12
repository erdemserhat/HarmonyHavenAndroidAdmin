package com.erdemserhat.harmonyadmin.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.erdemserhat.harmonyadmin.model.NotificationDto
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun GeneralNotificationScreen(
    modifier: Modifier = Modifier,
    viewModel:NotificationViewModel = hiltViewModel()

) {
    GeneralNotificationContent(
        modifier = modifier,
        onButtonClick = {viewModel.sendNotification(it)}

    )

}

@Composable
fun GeneralNotificationContent(
    modifier: Modifier = Modifier,
    onButtonClick:(notificationDto:NotificationDto)->Unit={}

) {
    var title by remember {
        mutableStateOf("")
    }

    var content by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Send General Notification",
                modifier = Modifier.padding(15.dp),
                fontSize = 25.sp,
                color = Color.Black

            )
            TextField(
                value = title,
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(0.9f),
                onValueChange = { title = it },
                placeholder = { Text(text = "Title") })
            TextField(
                value = content,
                onValueChange = { content = it },
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.3f),
                placeholder = { Text(text = "Content") })

            Button(
                onClick = {onButtonClick(NotificationDto(title,content))}

            ) {
                Text(text = "Send Notification")
                
            }
        }


    }


}

@Preview
@Composable
private fun GeneralNotificationContentPreview() {
    GeneralNotificationContent()

}

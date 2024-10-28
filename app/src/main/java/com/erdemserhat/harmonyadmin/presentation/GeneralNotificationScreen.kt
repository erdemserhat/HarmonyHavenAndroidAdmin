package com.erdemserhat.harmonyadmin.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.erdemserhat.harmonyadmin.model.NotificationDto
import com.erdemserhat.harmonyadmin.model.NotificationSpecificDto

@Composable
fun GeneralNotificationScreen(
    modifier: Modifier = Modifier,
    viewModel: NotificationViewModel = hiltViewModel()

) {
    GeneralNotificationContent(
        modifier = modifier,
        viewModel = viewModel

    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralNotificationContent(
    modifier: Modifier = Modifier,
    viewModel: NotificationViewModel = hiltViewModel()

) {
    var title by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var content by remember {
        mutableStateOf("")
    }

    var imageLing by remember {
        mutableStateOf("")
    }

    var screenCode by remember {
        mutableStateOf("1")
    }

    var isSpecific by remember {
        mutableStateOf(false)
    }

    var isAlertVisible by remember {
        mutableStateOf(false)
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
                text = "Send Notification",
                modifier = Modifier.padding(15.dp),
                fontSize = 25.sp,
                color = Color.Black

            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Checkbox ve başlık
                Checkbox(
                    checked = isSpecific,
                    onCheckedChange = { isSpecific = it } // Değeri doğrudan kullan
                )
                Text(text = "Specific ?") // Başlık
            }
            if (isSpecific) {
                TextField(
                    value = email,
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(0.9f),
                    onValueChange = { email = it },
                    placeholder = { Text(text = "Email") })


            }


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

            TextField(
                value = imageLing,
                onValueChange = { imageLing = it },
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.3f),
                placeholder = { Text(text = "Image Link") })


            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = screenCode,
                onValueChange = {

                    screenCode = it
                },
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.3f),
                placeholder = { Text(text = "Screen Code") })
            Row {
                Text(text = "0-->Main Screen * ", fontSize = 8.sp)
                Text(text = "0ID-->ARTICLE * ", fontSize = 8.sp)
                Text(text = "1-->NOTIFICATION * ", fontSize = 8.sp)
                Text(text = "2-->FLOW * ", fontSize = 8.sp)
            }






            Button(
                onClick = {
                    isAlertVisible = true



                }


            ) {
                Text(text = "Send Notification")

            }
        }

        if (isAlertVisible) {
            AlertDialog(onConfirm = {

                if (isSpecific) {
                    viewModel.sendNotificationSpecific(
                        NotificationSpecificDto(
                            email = (email) ,
                            notification = NotificationDto(
                                title = title,
                                body = content,
                                image = imageLing,
                                screen = screenCode
                            )
                        )
                    )
                } else {

                    viewModel.sendNotification(
                        NotificationDto(
                            title = title,
                            body = content,
                            image = imageLing,
                            screen = screenCode
                        )
                    )
                }
                isAlertVisible = false





            }, onDismiss = {isAlertVisible = false}

            )

        }


    }


}

@Preview
@Composable
private fun GeneralNotificationContentPreview() {
    GeneralNotificationContent()

}

@Composable
fun AlertDialog(modifier: Modifier = Modifier, onConfirm: () -> Unit, onDismiss: () -> Unit) {

    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        },
        text = { Text(text = "Are you sure to send") }
    )
}

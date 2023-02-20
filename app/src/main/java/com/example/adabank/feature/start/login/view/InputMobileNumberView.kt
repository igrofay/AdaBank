package com.example.adabank.feature.start.login.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adabank.R
import com.example.adabank.feature.common.theme.PoppinsFamily
import com.example.adabank.feature.common.view.button.CustomButton
import com.example.adabank.feature.common.view.num_keyboard.NumKeyboard
import com.example.adabank.feature.common.view_model.EventBase
import com.example.adabank.feature.start.login.model.LoginEvent
import com.example.adabank.feature.start.login.model.LoginState

@Composable
fun InputMobileNumberView(
    state: LoginState,
    eventBase: EventBase<LoginEvent>,
    listCodeCountry: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 30.dp)
                .height(42.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(Color.White, CircleShape),
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(1.5f)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "AdaBank",
                fontFamily = PoppinsFamily,
                fontSize = 33.sp,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.W500,
                modifier = Modifier.wrapContentHeight(unbounded = true)
            )
        }
        Text(
            text = "Welcome",
            fontFamily = PoppinsFamily,
            fontSize = 33.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Enter your mobile number  for Continue",
            fontFamily = PoppinsFamily,
            fontSize = 13.sp,
            color = MaterialTheme.colors.onBackground.copy(0.5f),
        )
        Spacer(modifier = Modifier.height(48.dp))
        Row {
            BoxWithConstraints(
                modifier = Modifier.weight(0.25f)
            ) {
                Column {
                    Row {
                        Text(
                            text = state.codeCountry,
                            fontFamily = PoppinsFamily,
                            fontSize = 17.sp,
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(
                            onClick = { eventBase.onEvent(LoginEvent.ShowListCodeCountry(true)) },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                            )
                        }
                    }
                    Divider(
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.padding(top = 12.dp),
                        thickness = 1.5.dp,
                    )
                }
                DropdownMenu(
                    expanded = state.isSelectCodeCountry,
                    onDismissRequest = { eventBase.onEvent(LoginEvent.ShowListCodeCountry(false)) },
                    modifier = Modifier
                        .width(maxWidth)
                        .background(Color.White)
                ) {
                    listCodeCountry.forEachIndexed { index, code ->
                        Text(
                            text = code,
                            fontFamily = PoppinsFamily,
                            fontSize = 17.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { eventBase.onEvent(LoginEvent.ChangeCodeCountry(index)) }
                                .padding(start = 6.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = state.mobileNumber,
                    fontFamily = PoppinsFamily,
                    fontSize = 17.sp,
                )
                Divider(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.padding(top = 12.dp),
                    thickness = 1.5.dp,
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        NumKeyboard(
            onClick = {eventBase.onEvent(LoginEvent.InputNumber(it))},
            onDelete = {eventBase.onEvent(LoginEvent.DeleteLeftNumFromMobileNumber)}
        )
        CustomButton(label = "Next") {
            eventBase.onEvent(LoginEvent.VerificationMobileNumber)
        }
    }
}
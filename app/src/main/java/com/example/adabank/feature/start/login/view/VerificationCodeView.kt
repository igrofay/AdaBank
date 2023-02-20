package com.example.adabank.feature.start.login.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adabank.feature.common.theme.PoppinsFamily
import com.example.adabank.feature.common.view.input_code.InputCode
import com.example.adabank.feature.common.view_model.EventBase
import com.example.adabank.feature.start.login.model.LoginEvent
import com.example.adabank.feature.start.login.model.LoginState

@Composable
fun VerificationCodeView(
    loginState: LoginState,
    eventBase: EventBase<LoginEvent>,
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .padding(35.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Verification Code",
            fontFamily = PoppinsFamily,
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(12.dp))
        val text = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    color = MaterialTheme.colors.onBackground.copy(0.5f)
                )
            ) {
                append("We have sent the code verification to your mobile number. ")
            }
            pushStringAnnotation(tag = "close", annotation = "")
            withStyle(
                SpanStyle(
                    color = MaterialTheme.colors.primary.copy(0.5f)
                )
            ) {
                append("Wrong number ?")
            }
            pop()
        }
        ClickableText(
            text = text,
            onClick = {offset ->
                text.getStringAnnotations("close", offset, offset)
                    .firstOrNull()?.let {
                        eventBase.onEvent(LoginEvent.CloseVerificationMobileNumber)
                    }
            },
            modifier = Modifier.fillMaxWidth(0.9f),
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = PoppinsFamily,
                textAlign = TextAlign.Center,
            ),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colors.primary)
                .padding(horizontal = 12.dp, vertical = 2.dp)
        ){
            Text(
                text = loginState.codeCountry+loginState.mobileNumber,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false,
                    ),
                    fontFamily = PoppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                    color = Color.White,
                ),
            )
        }
        Spacer(modifier = Modifier.height(44.dp))
        val value = remember {
            mutableStateListOf<Char>()
        }
        InputCode(
            count = 4,
            value = value,
            inputFromSystemKeyboard = true,
            onChangeValue = {
                value.clear()
                value.addAll(it)
            },
            isError = value.size == 4,
            showCode = true
        )
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = "Resend Code in 00:48",
            fontFamily = PoppinsFamily,
            fontSize = 13.sp,
            color = MaterialTheme.colors.onBackground.copy(0.5f)
        )
    }
}
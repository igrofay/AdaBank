package com.example.adabank.feature.common.view.pin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adabank.feature.common.theme.PoppinsFamily
import com.example.adabank.feature.common.view.button.CustomButton
import com.example.adabank.feature.common.view.input_code.InputCode
import com.example.adabank.feature.common.view.num_keyboard.NumKeyboard

@Composable
fun InputPinScreen(
    value: String,
    onChangeValue: (String)->Unit,
    isSetPin: Boolean,
    isError: Boolean,
    next: (()->Unit)? = null,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(0.4f))
        Text(
            text = if (isSetPin) "Set your PIN" else "Input your PIN",
            fontFamily = PoppinsFamily,
            fontSize = 33.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.onBackground
        )
        if (isSetPin){
            Text(
                text = "You will get use this to login next time",
                fontFamily = PoppinsFamily,
                fontSize = 13.sp,
                color = MaterialTheme.colors.onBackground.copy(0.5f)
            )
        }
        Spacer(modifier = Modifier.weight(0.35f))
        InputCode(
            count = 4,
            value = value.toList(),
            showCode = false,
            isError = isError,
        )
        Spacer(modifier = Modifier.weight(1f))
        NumKeyboard(
            onClick = {
                if(value.length < 4) {
                    onChangeValue(value+it)
                }
            },
            onDelete = {
                onChangeValue(value.dropLast(1))
            }
        )
        next?.let {
            CustomButton(
                label = "Next",
                onClick = it
            )
        }
    }
}
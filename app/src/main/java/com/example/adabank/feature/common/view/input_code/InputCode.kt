package com.example.adabank.feature.common.view.input_code

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.adabank.feature.common.view.effect.shakeClickEffect

@Composable
fun InputCode(
    count: Int,
    value: List<Char>,
    isError: Boolean = false,
    inputFromSystemKeyboard: Boolean = false,
    onChangeValue: ((List<Char>)-> Unit)? = null,
    showCode:Boolean = true
) {
    Box(
        modifier = Modifier.shakeClickEffect(isError),
        contentAlignment = Alignment.Center
    ){
        if(inputFromSystemKeyboard){
            InputCodeFromSystemKeyboard(count, value, showCode, onChangeValue)
        }else{
            DisplayInputCode(count, value, showCode)
        }
    }
}
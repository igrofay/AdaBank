package com.example.adabank.feature.common.view.input_code

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adabank.feature.common.theme.PoppinsFamily

@Composable
fun InputCodeFromSystemKeyboard(
    count: Int,
    value: List<Char>,
    showCode: Boolean,
    onChangeValue: ((List<Char>) -> Unit)?
) {
    val arrayNumber = Array(10) { '0' + it }
    val focusManager = LocalFocusManager.current
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        for (i in 0 until count) {

            val text = if (value.getOrNull(i) == null) ""
            else if (showCode) value[i].toString()
            else "★"
            BasicTextField(
                value = text,
                onValueChange = {
                    if (it.lastOrNull() in arrayNumber){
                        if(text.isEmpty()){
                            onChangeValue?.invoke(value.insertAt(i, it.last()))
                        }else{
                            onChangeValue?.invoke(value.replaceAt(i, it.last()))
                        }
                        focusManager.moveFocus(FocusDirection.Right)
                    }else{
                        onChangeValue?.invoke(value.putAway(i))
                        focusManager.moveFocus(FocusDirection.Left)
                    }
                },
                textStyle = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false,
                    ),
                    fontFamily = PoppinsFamily,
                    fontSize = 24.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                ),
                singleLine = true,
                cursorBrush = SolidColor(Color.White.copy(0.8f)),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next,
                ),
            ){innerTextField ->
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(MaterialTheme.colors.primary),
                    contentAlignment = Alignment.Center
                ) {
                    innerTextField()
                }
            }
        }
    }
}

private fun <T> List<T>.putAway(index:Int): List<T> {
    val list = mutableListOf<T>()
    for (item in this.indices) {
        if (index == item)
            continue
        list.add(this[item])
    }
    return list
}
private fun <T> List<T>.insertAt(index:Int, value: T): List<T> {
    val list = mutableListOf<T>()
    if (index >= this.size) {
        list.addAll(this)
        list.add(value)
    }else{
        for (item in this.indices) {
            if (index == item) list.add(value)
            list.add(this[item])
        }
    }
    return list
}
private fun <T> List<T>.replaceAt(index:Int, value: T): List<T> {
    val list = mutableListOf<T>()
    for (item in this.indices) {
        if (index == item) {
            list.add(value)
            continue
        }
        list.add(this[item])
    }
    return list
}
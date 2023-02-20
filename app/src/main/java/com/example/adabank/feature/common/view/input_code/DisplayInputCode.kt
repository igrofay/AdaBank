package com.example.adabank.feature.common.view.input_code

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adabank.feature.common.theme.PoppinsFamily


@Composable
fun DisplayInputCode(
    count: Int,
    value: List<Char>,
    showCode:Boolean,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        for (i in 0 until count){
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colors.primary),
                contentAlignment = Alignment.Center
            ){
                val text = if (value.getOrNull(i) == null) ""
                else if(showCode) value[i].toString()
                else "★"
                Text(
                    text = text,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false,
                        ),
                        fontFamily = PoppinsFamily,
                        fontSize = 24.sp,
                        color = Color.White,
                    )
                )
            }
        }
    }
}
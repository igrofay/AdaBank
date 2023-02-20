package com.example.adabank.feature.common.view.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adabank.feature.common.theme.PoppinsFamily
import com.example.adabank.feature.common.view.click.alphaClick
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun VerticalIconButton(
    image: Any,
    label: String,
    isIcon: Boolean,
    textColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(20.dp),
    onClick: ()->Unit,
) {
    Column(
        modifier = Modifier
            .width(56.dp)
            .alphaClick(onClick),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if (isIcon && image is Int){
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(shape)
                    .background(MaterialTheme.colors.secondary),
                contentAlignment = Alignment.Center,
            ){
                Icon(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colors.primary
                )
            }
        }else{
            GlideImage(
                imageModel = { image },
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(20.dp)),
            )
        }
        Text(
            text = label,
            modifier = Modifier
                .fillMaxWidth(),
            style = TextStyle(
                color = textColor,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                fontFamily = PoppinsFamily
            )
        )
    }
}
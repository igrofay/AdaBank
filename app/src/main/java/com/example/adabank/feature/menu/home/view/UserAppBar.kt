package com.example.adabank.feature.menu.home.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adabank.domain.model.UserModel
import com.example.adabank.feature.common.theme.PoppinsFamily
import com.example.adabank.feature.common.theme.white
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun UserAppBar(
    userModel: UserModel,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(peekHeight)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(
                text = "Welcome",
                fontFamily = PoppinsFamily,
                fontSize = 15.sp,
                color = Color.White
                    .copy(0.5f)
            )
            Text(
                text = userModel.name,
                fontFamily = PoppinsFamily,
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .size(61.dp)
                .border(
                    1.5.dp,
                    Brush.verticalGradient(
                        listOf(
                            white.copy(0.6f),
                            white.copy(0.1f),
                        )
                    ),
                    CircleShape
                ),
            contentAlignment = Alignment.Center,
        ) {
            GlideImage(
                imageModel = { userModel.imageURL },
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
        }
    }
}
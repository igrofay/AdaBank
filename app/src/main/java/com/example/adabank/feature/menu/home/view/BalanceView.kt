package com.example.adabank.feature.menu.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adabank.R
import com.example.adabank.domain.model.Currency.Companion.toChar
import com.example.adabank.domain.model.Currency.Companion.toIndicator
import com.example.adabank.domain.model.UserModel
import com.example.adabank.feature.common.theme.PoppinsFamily
import com.example.adabank.feature.common.theme.white
import com.example.adabank.feature.common.view.button.VerticalIconButton
import com.example.adabank.feature.common.view.click.bounceClick

@Composable
fun BalanceView(
    userModel: UserModel,
) {
    var showBalance by remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .border(
                2.dp,
                Brush.verticalGradient(
                    listOf(
                        white.copy(0.5f),
                        white.copy(0.05f),
                    ),
                ),
                MaterialTheme.shapes.large
            )
            .background(white.copy(0.15f), MaterialTheme.shapes.large)
            .padding(20.dp),
        horizontalAlignment = CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .align(TopCenter),
                horizontalAlignment = CenterHorizontally
            ) {
                Text(
                    text = "Total balance",
                    fontFamily = PoppinsFamily,
                    fontSize = 13.sp,
                    color = Color.White.copy(0.6f)
                )
                Text(
                    text = if (showBalance)
                        "${userModel.currency.toChar()}${userModel.totalBalance}"
                    else
                        "${userModel.currency.toChar()}***",
                    fontFamily = PoppinsFamily,
                    fontSize = 45.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                )
            }
            Icon(
                painter = painterResource(R.drawable.ic_eye),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .align(TopEnd)
                    .size(20.dp)
                    .bounceClick { showBalance = !showBalance }
            )
        }
        Row(
            modifier = Modifier
                .bounceClick {}
                .background(Color.White.copy(0.3f), CircleShape)
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = userModel.currency.toIndicator(),
                style = TextStyle(
                    fontFamily = PoppinsFamily,
                    fontSize = 11.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W500,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    ),
                )
            )
            Icon(
                painter = painterResource(R.drawable.ic_arrow_down),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .height(14.dp),
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Divider(color = Color.White.copy(0.7f), thickness = 0.5.dp)
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            VerticalIconButton(
                image = R.drawable.ic_arrow_right_square,
                label = "Transfer",
                isIcon = true,
            ) {

            }
            VerticalIconButton(
                image = R.drawable.ic_top_up,
                label = "Top-up",
                isIcon = true,
            ) {

            }
            VerticalIconButton(
                image = R.drawable.ic_wallet,
                label = "Bill",
                isIcon = true,
            ) {

            }
            VerticalIconButton(
                image = R.drawable.ic_category,
                label = "More",
                isIcon = true,
            ) {

            }
        }
    }
}
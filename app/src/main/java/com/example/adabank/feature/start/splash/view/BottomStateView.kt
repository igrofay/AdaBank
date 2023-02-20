package com.example.adabank.feature.start.splash.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adabank.R
import com.example.adabank.feature.common.theme.PoppinsFamily
import com.example.adabank.feature.start.splash.model.SplashState

@Composable
fun BottomStateView(
    splashState: SplashState,
    firstTime: () -> Unit,
) {
    if (splashState == SplashState.FirstTime){
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Start Payments Easily In The Digital Age",
                fontWeight = FontWeight.SemiBold,
                fontSize = 25.sp,
                fontFamily = PoppinsFamily,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Payment tool that is easy and fast to use in this easy-to-use digital era. Use the features that make your business easier",
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                fontFamily = PoppinsFamily,
                color = MaterialTheme.colors.onBackground.copy(0.5f),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))
            FloatingActionButton(
                onClick = firstTime,
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_right),
                    contentDescription = null,
                    tint = MaterialTheme.colors.background
                )
            }
        }
    }else{
        CircularProgressIndicator()
    }
}
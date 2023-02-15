package com.example.adabank.feature.start.splash.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.adabank.R
import com.example.adabank.feature.common.theme.PoppinsFamily
import com.example.adabank.feature.common.theme.green
import com.example.adabank.feature.start.splash.model.SplashState
import com.example.adabank.feature.start.splash.view_model.SplashVM
import com.example.adabank.feature.common.theme.white

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SplashScreen(
    viewModel: SplashVM = hiltViewModel(),
    needSignIn: () -> Unit,
    needInputPin: () -> Unit,
) {
    val state by viewModel.state
    LaunchedEffect(state) {
        if (state == SplashState.Registered) {
            needInputPin()
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.im_wallet),
                contentDescription = null,
                modifier = Modifier.height(400.dp)
            )
        }
        AnimatedVisibility(
            visible = state == SplashState.FirstTime,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .weight(0.85f)
                .padding(vertical = 12.dp),
            enter = scaleIn() + fadeIn()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        3.dp,
                        Brush.verticalGradient(
                            listOf(Color.White.copy(0.5f), white.copy(0.05f))
                        ),
                        MaterialTheme.shapes.large
                    )
                    .padding(3.dp)
                    .background(
                        MaterialTheme.colors.background,
                        MaterialTheme.shapes.large
                    )
                    .padding(35.dp),
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
                    onClick = needSignIn,
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
        }
    }
}
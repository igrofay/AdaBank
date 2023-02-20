package com.example.adabank.feature.start.splash.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.adabank.R
import com.example.adabank.feature.common.theme.white
import com.example.adabank.feature.start.splash.model.SplashState
import com.example.adabank.feature.start.splash.view_model.SplashVM


@Composable
fun SplashScreen(
    needSignIn: () -> Unit,
    needInputPin: () -> Unit,
    viewModel: SplashVM = hiltViewModel(),
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
                .fillMaxWidth()
                .drawWithContent {
                    rotate(-40f, Offset(size.width / 6, size.height / 6)) {
                        drawCircle(
                            Brush.verticalGradient(
                                listOf(Color.Transparent, Color.White.copy(0.2f))
                            ),
                            center = Offset(size.width / 5, size.height / 4)
                        )
                    }
                    rotate(-40f) {
                        drawCircle(
                            Brush.verticalGradient(
                                listOf(Color.Transparent, Color.White.copy(0.2f))
                            ),
                        )
                    }
                    drawContent()
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.im_wallet),
                contentDescription = null,
                modifier = Modifier.height(400.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .weight(0.85f)
                .padding(vertical = 12.dp)
                .border(
                    width = 3.dp,
                    brush = Brush.verticalGradient(
                        listOf(Color.White.copy(0.5f), white.copy(0.05f))
                    ),
                    shape = MaterialTheme.shapes.large
                )
                .padding(3.dp)
                .background(
                    color = MaterialTheme.colors.background,
                    shape = MaterialTheme.shapes.large
                )
                .padding(35.dp),
            contentAlignment = Alignment.Center
        ){
            BottomStateView(
                splashState = state,
                firstTime = needSignIn
            )
        }
    }
}
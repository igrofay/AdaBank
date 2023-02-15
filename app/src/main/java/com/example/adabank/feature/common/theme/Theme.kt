package com.example.adabank.feature.common.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = colorPrimary,
    secondary = yellow,
    background = white,
    onBackground = black,
    surface = green
)

@Composable
fun ApplicationTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
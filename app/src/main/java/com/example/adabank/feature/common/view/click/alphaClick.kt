package com.example.adabank.feature.common.view.click

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.pointerInput

enum class AlphaBounceButtonState { Pressed, Idle }

fun Modifier.alphaClick(
    onClick: ()->Unit
) = composed {
    var buttonState by remember { mutableStateOf(AlphaBounceButtonState.Idle) }
    val alpha by animateFloatAsState(if (buttonState == AlphaBounceButtonState.Pressed) 0.70f else 1f)

    this
        .alpha(alpha)
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onClick
        )
        .pointerInput(buttonState) {
            awaitPointerEventScope {
                buttonState = if (buttonState == AlphaBounceButtonState.Pressed) {
                    waitForUpOrCancellation()
                    AlphaBounceButtonState.Idle
                } else {
                    awaitFirstDown(false)
                    AlphaBounceButtonState.Pressed
                }
            }
        }
}
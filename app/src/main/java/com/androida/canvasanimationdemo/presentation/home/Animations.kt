package com.androida.canvasanimationdemo.presentation.home

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.androida.canvasanimationdemo.R


enum class HeartAnimationState {
    Hidden,
    Shown
}

@Composable
fun HeartImage(heartAnimationState: MutableState<HeartAnimationState>) {
    val transition = updateTransition(
        targetState = heartAnimationState.value,
        label = "Heart Transition"
    )
    val heartSize by transition.animateDp(
        label = "Size Animation",
        transitionSpec = {
            if (HeartAnimationState.Shown isTransitioningTo HeartAnimationState.Hidden) {
                tween(durationMillis = 500)
            } else {
                keyframes {
                    durationMillis = 500
                    0.0.dp at 0 with FastOutSlowInEasing
                    150.dp at 400 with FastOutSlowInEasing
                }
            }
        }
    ) { state ->
        when (state) {
            HeartAnimationState.Hidden -> 0.dp
            HeartAnimationState.Shown -> 100.dp
        }
    }

    if (transition.currentState == transition.targetState) {
        heartAnimationState.value = HeartAnimationState.Hidden
    }
    Image(
        painter = painterResource(id = R.drawable.baseline_favorite_24),
        contentDescription = "Heart Animation",
        colorFilter = ColorFilter.tint(Color.Red),
        modifier = Modifier.size(heartSize)
    )
}






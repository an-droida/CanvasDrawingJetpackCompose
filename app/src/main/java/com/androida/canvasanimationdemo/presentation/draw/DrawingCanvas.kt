package com.androida.canvasanimationdemo.presentation.draw

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp
import com.androida.canvasanimationdemo.models.PathStateModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DrawingCanvas(
    drawColor: MutableState<Color>,
    drawBrush: MutableState<Float>,
    path: MutableList<PathStateModel>,
) {
    val currentPath = path.last().path
    val movePath = remember { mutableStateOf<Offset?>(null) }

    Canvas(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .padding(top = 100.dp)
            .pointerInteropFilter{ event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        currentPath.moveTo(event.x, event.y)
                    }
                    MotionEvent.ACTION_MOVE -> {
                        movePath.value = Offset(event.x, event.y)
                    }
                    MotionEvent.ACTION_UP -> {
                        movePath.value = null
                    }
                }
                true
            }
    ) {
        movePath.value?.let {
            currentPath.lineTo(it.x, it.y)
            drawPath(
                path = currentPath,
                color = drawColor.value,
                style = Stroke(drawBrush.value)
            )
        }
        path.forEach {
            drawPath(
                path = it.path,
                color = it.color,
                style = Stroke(it.stroke)
            )
        }
    }
}
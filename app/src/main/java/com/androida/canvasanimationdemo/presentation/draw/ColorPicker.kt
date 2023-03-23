package com.androida.canvasanimationdemo.presentation.draw

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.androida.canvasanimationdemo.data.colors

@Composable
fun ColorPicker(onColorSelected: (Color) -> Unit) {

    val colorsList by remember { mutableStateOf(colors) }
    var selectedColor by remember { mutableStateOf(colors.first()) }

    Canvas(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .height(1.dp)
    ) {
        drawRect(
            brush = Brush.horizontalGradient(
                colors = colors,
            )
        )

    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item {
            Spacer(modifier = Modifier.width(10.dp))
        }
        items(colorsList) { color ->
            val isClicked = color == selectedColor
            val scale by animateFloatAsState(
                if (isClicked) 1.3f else 1f
            )
            Canvas(
                modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)
                    .scale(scale)
                    .clickable(onClick = {
                        if (!isClicked) {
                            onColorSelected(color)
                            selectedColor = color
                        }
                    })
            ) {
                drawCircle(
                    color = color,
                    radius = size.width / 2,
                )
            }
        }
        item {
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}


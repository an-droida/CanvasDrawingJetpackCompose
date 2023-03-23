package com.androida.canvasanimationdemo.presentation.draw

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.androida.canvasanimationdemo.data.colors
import com.androida.canvasanimationdemo.models.PathStateModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawingScreen(
    navController: NavHostController
) {
    val path = remember { mutableStateListOf<PathStateModel>() }
    val drawColor = remember { mutableStateOf(colors.first()) }
    val drawBrush = remember { mutableStateOf(15f) }

    path.add(PathStateModel(Path(), drawColor.value, drawBrush.value))

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Draw Something...", fontSize = 16.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        path.clear()
                        path.add(PathStateModel(Path(), drawColor.value, drawBrush.value))
                    }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete"
                        )
                    }
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier.padding(padding)
            ) {
                Column(modifier = Modifier.fillMaxSize()) {

                    ColorPicker(onColorSelected = { drawColor.value = it })

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(10.dp),
                        shape = RoundedCornerShape(10.dp),
                        elevation = CardDefaults.elevatedCardElevation(10.dp)
                    ) {
                        DrawingCanvas(
                            drawColor,
                            drawBrush,
                            path,
                        )
                    }
                }
            }
        }
    )
}


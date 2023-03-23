package com.androida.canvasanimationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.androida.canvasanimationdemo.data.postList
import com.androida.canvasanimationdemo.presentation.draw.DrawingScreen
import com.androida.canvasanimationdemo.presentation.home.HomeScreen
import com.androida.canvasanimationdemo.ui.theme.CanvasAnimationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CanvasAnimationDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController, startDestination = "HomeScreen") {
                        composable("HomeScreen") { HomeScreen(posts = postList, navController) }
                        composable("DrawScreen") { DrawingScreen(navController) }
                    }
                }
            }
        }
    }
}

package com.androida.canvasanimationdemo.data

import androidx.compose.ui.graphics.Color
import com.androida.canvasanimationdemo.R
import com.androida.canvasanimationdemo.models.PostModel
import com.androida.canvasanimationdemo.models.UserModel
import java.util.*


val postList = listOf(
    PostModel(
        UUID.randomUUID(),
        text = "Hello world!",
        UserModel(profileImage = R.drawable.baseline_supervised_user_circle_24, userName = "Alice"),
        likes = 5,
        comments = 2,
        hasBeenLiked = true,
        attachedImage = "https://images.unsplash.com/photo-1575936123452-b67c3203c357?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aW1hZ2V8ZW58MHx8MHx8&w=1000&q=80"
    ),
    PostModel(
        UUID.randomUUID(),
        "How's it going, everyone?",
        UserModel(profileImage = R.drawable.baseline_supervised_user_circle_24, "Bob"),
        3,
        1,
        false,
        "https://images.unsplash.com/photo-1506434304575-afbb92660c28?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE0fHx8ZW58MHx8fHw%3D&w=1000&q=80"
    ),
    PostModel(
        UUID.randomUUID(),
        "Check out this cool photo!",
        UserModel(profileImage = R.drawable.baseline_supervised_user_circle_24, "Charlie"),
        10,
        5,
        false,
        "https://jes.edu.vn/wp-content/uploads/2017/10/h%C3%ACnh-%E1%BA%A3nh.jpg"
    ),
    // Add more posts here...
)


val colors = listOf(
    Color.Black,
    Color.DarkGray,
    Color.Gray,
    Color.LightGray,
    Color.White,
    Color.Red,
    Color.Green,
    Color.Blue,
    Color.Yellow,
    Color.Magenta,
    Color.Cyan,
    Color(0xFF800080), // Purple
    Color(0xFF9932CC), // Dark Orchid
    Color(0xFF8B0000), // Dark Red
    Color(0xFFA52A2A), // Brown
    Color(0xFFBDB76B), // Dark Khaki
    Color(0xFF000080), // Navy
    Color(0xFF00CED1), // Dark Turquoise
    Color(0xFF008080), // Teal
    Color(0xFF00FF00), // Lime
    Color(0xFFFA8072), // Salmon
    Color(0xFFDAA520), // Goldenrod
    Color(0xFF9400D3), // Dark Violet
    Color(0xFFC71585), // Medium Violet Red
    Color(0xFFFF69B4), // Hot Pink
    Color(0xFFFFD700), // Gold
    Color(0xFFCD5C5C), // Indian Red
    Color(0xFF4B0082), // Indigo
    Color(0xFF7B68EE), // Medium Slate Blue
    Color(0xFF40E0D0), // Turquoise
    Color(0xFFFF00FF), // Fuchsia
    Color(0xFFFFA500) // Orange
)


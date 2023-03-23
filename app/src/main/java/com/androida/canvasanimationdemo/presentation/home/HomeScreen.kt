package com.androida.canvasanimationdemo.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.androida.canvasanimationdemo.R
import com.androida.canvasanimationdemo.models.PostModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(posts: List<PostModel>, navController: NavController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("DrawScreen") }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        },
        content = { paddingValues ->
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(posts) { post ->
                    PostItem(post)
                }
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostItem(post: PostModel) {
    val heartAnimationState = remember { mutableStateOf(HeartAnimationState.Hidden) }
    val likedImage = remember { mutableStateOf(post.hasBeenLiked) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(post.user.profileImage),
                contentDescription = "Profile image",
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp)
                    .clip(CircleShape)
            )
            Text(
                text = post.user.userName,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = post.text,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    painter = rememberImagePainter(post.attachedImage),
                    contentDescription = "Attached image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                HeartImage(heartAnimationState)
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.padding(horizontal = 12.dp)) {
                Icon(
                    painter = painterResource(
                        id = if (likedImage.value) R.drawable.baseline_favorite_24
                        else R.drawable.baseline_favorite_border_24
                    ),
                    contentDescription = "Like",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            post.hasBeenLiked = !post.hasBeenLiked
                            likedImage.value = post.hasBeenLiked
                            if (post.hasBeenLiked) {
                                post.likes += 1
                            } else {
                                post.likes -= 1
                            }
                            heartAnimationState.value = if (!post.hasBeenLiked) {
                                HeartAnimationState.Hidden
                            } else {
                                HeartAnimationState.Shown
                            }
                        },
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = post.likes.toString())
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    painter = painterResource(R.drawable.baseline_comment_24),
                    contentDescription = "Comment",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = post.comments.toString())
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
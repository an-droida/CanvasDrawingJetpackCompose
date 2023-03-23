package com.androida.canvasanimationdemo.models

import java.util.*

data class PostModel(
    val id: UUID,
    val text: String,
    val user: UserModel,
    var likes: Int,
    val comments: Int,
    var hasBeenLiked: Boolean,
    val attachedImage: String
)


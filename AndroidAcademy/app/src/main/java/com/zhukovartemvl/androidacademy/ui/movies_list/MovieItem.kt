package com.zhukovartemvl.androidacademy.ui.movies_list


data class MovieItem(
    val id: Int,
    val name: String,
    val previewImageURL: String,
    val tags: String,
    val rating: Float,
    val durationMinutes: Int,
    val reviewsCount: Int,
    val pg: String,
    var isLiked: Boolean = false
)

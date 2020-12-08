package com.zhukovartemvl.androidacademy.ui.model


data class MovieView(
    val id: Int,
    val name: String,
    val previewImageURL: String,
    val tags: String,
    val rating: Float,
    val durationMinutes: Int,
    val reviewsCount: Int,
    val pg: String,
    var isFavorite: Boolean = false
)

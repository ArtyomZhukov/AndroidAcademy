package com.zhukovartemvl.androidacademy.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Movie(
    val id: Int,
    val name: String,
    val previewImageURL: String,
    val backgroundImageURL: String,
    val tags: List<String>,
    var rating: Float,
    val durationMinutes: Int,
    val reviewsCount: Int,
    val storyline: String,
    val actors: List<Actor>,
    val pg: Int,
    var isFavorite: Boolean
) : Parcelable

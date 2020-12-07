package com.zhukovartemvl.androidacademy.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Movie(
    val id: Int,
    val name: String,
    val previewImageURL: String,
    val tags: List<String>,
    val rating: Float,
    val durationMinutes: Int,
    val reviewsCount: Int,
    val storyline: String,
    val actors: List<Actor>,
    val pg: Int,
    var isLiked: Boolean
) : Parcelable

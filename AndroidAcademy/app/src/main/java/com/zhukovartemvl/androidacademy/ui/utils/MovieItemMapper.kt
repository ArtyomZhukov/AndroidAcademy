package com.zhukovartemvl.androidacademy.ui.utils

import com.zhukovartemvl.androidacademy.data.model.Movie
import com.zhukovartemvl.androidacademy.ui.model.MovieView


fun Movie.toMovieItem(): MovieView {
    val tagsText = tags.toString().drop(1).dropLast(1)
    val pgText = "$pg+"
    return MovieView(
        id,
        name,
        previewImageURL,
        tagsText,
        rating,
        durationMinutes,
        reviewsCount,
        pgText,
        isFavorite
    )
}

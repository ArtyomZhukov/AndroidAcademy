package com.zhukovartemvl.androidacademy.data.mapper

import com.zhukovartemvl.androidacademy.data.model.Movie
import com.zhukovartemvl.androidacademy.ui.movies_list.MovieItem


fun Movie.toMovieItem(): MovieItem {
    val tagsText = tags.toString().drop(1).dropLast(1)
    val pgText = "$pg+"
    return MovieItem(
        id,
        name,
        previewImageURL,
        tagsText,
        rating,
        durationMinutes,
        reviewsCount,
        pgText,
        isLiked
    )
}

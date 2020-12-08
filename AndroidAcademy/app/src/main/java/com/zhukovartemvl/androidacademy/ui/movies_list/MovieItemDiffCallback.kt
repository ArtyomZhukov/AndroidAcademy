package com.zhukovartemvl.androidacademy.ui.movies_list

import androidx.recyclerview.widget.DiffUtil
import com.zhukovartemvl.androidacademy.ui.model.MovieView


class MovieItemDiffCallback : DiffUtil.ItemCallback<MovieView>() {

    override fun areItemsTheSame(old: MovieView, new: MovieView) = old.name == new.name
    override fun areContentsTheSame(old: MovieView, new: MovieView) = old == new

}

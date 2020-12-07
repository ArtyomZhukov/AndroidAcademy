package com.zhukovartemvl.androidacademy.ui.movies_list

import androidx.recyclerview.widget.DiffUtil


class MovieItemDiffCallback : DiffUtil.ItemCallback<MovieItem>() {

    override fun areItemsTheSame(old: MovieItem, new: MovieItem) = old.name == new.name
    override fun areContentsTheSame(old: MovieItem, new: MovieItem) = old == new

}

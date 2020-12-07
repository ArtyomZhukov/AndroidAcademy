package com.zhukovartemvl.androidacademy.ui.movie_details

import androidx.recyclerview.widget.DiffUtil


class ActorItemDiffCallback : DiffUtil.ItemCallback<ActorItem>() {

    override fun areItemsTheSame(old: ActorItem, new: ActorItem) = old.name == new.name
    override fun areContentsTheSame(old: ActorItem, new: ActorItem) = old == new

}

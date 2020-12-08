package com.zhukovartemvl.androidacademy.ui.movie_details

import androidx.recyclerview.widget.DiffUtil
import com.zhukovartemvl.androidacademy.ui.model.ActorView


class ActorItemDiffCallback : DiffUtil.ItemCallback<ActorView>() {

    override fun areItemsTheSame(old: ActorView, new: ActorView) = old.name == new.name
    override fun areContentsTheSame(old: ActorView, new: ActorView) = old == new

}

package com.zhukovartemvl.androidacademy.ui.movie_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.zhukovartemvl.androidacademy.R
import com.zhukovartemvl.androidacademy.databinding.ItemActorBinding
import com.zhukovartemvl.androidacademy.ui.model.ActorView


class ActorsAdapter : ListAdapter<ActorView, ActorsAdapter.ViewHolder>(ActorItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemActorBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val view: ItemActorBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: ActorView) {
            view.apply {
                image.load(item.imageURL) {
                    placeholder(R.drawable.placeholder_actor)
                    transformations(RoundedCornersTransformation(6.0f))
                }

                text.text = item.name
            }
        }
    }

}

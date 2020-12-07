package com.zhukovartemvl.androidacademy.ui.movie_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zhukovartemvl.androidacademy.R
import com.zhukovartemvl.androidacademy.databinding.ItemActorBinding


class ActorsAdapter : ListAdapter<ActorItem, ActorsAdapter.ViewHolder>(ActorItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemActorBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemActorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ActorItem) {
            with(binding) {
                text.text = item.name
                Glide.with(binding.root)
                    .load(item.imageURL)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.image_placeholder)
                            .fallback(R.drawable.image_placeholder)
                    ).into(image)
            }
        }
    }

}

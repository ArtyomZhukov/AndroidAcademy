package com.zhukovartemvl.androidacademy.ui.movies_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zhukovartemvl.androidacademy.R
import com.zhukovartemvl.androidacademy.databinding.ItemMovieBinding


class MoviesAdapter : ListAdapter<MovieItem, MoviesAdapter.ViewHolder>(MovieItemDiffCallback()) {

    private var onLikeButtonClick: OnMovieClickListener? = null

    fun attachCallback(callback: OnMovieClickListener) {
        onLikeButtonClick = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onLikeButtonClick)
    }

    class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: MovieItem, onClickListener: OnMovieClickListener?) {
            with(binding) {
                val resources = binding.root.context.resources

                root.setOnClickListener { onClickListener?.onMovieItemClick(model.id) }

                Glide.with(binding.root)
                    .load(model.previewImageURL)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.image_placeholder)
                            .fallback(R.drawable.image_placeholder)
                    ).into(moviePreviewImage)

                pg.textPG.text = model.pg

                val likeButtonColorId = when {
                    model.isLiked -> R.color.likeEnabled
                    else -> R.color.likeDisabled
                }
                val likeButtonColor = resources.getColor(likeButtonColorId)
                DrawableCompat.setTint(likeButton.drawable, likeButtonColor)
                likeButton.setOnClickListener { onClickListener?.onLikeButtonClick(model.id) }

                tags.text = model.tags
                ratingBar.rating = model.rating
                reviews.text = resources.getQuantityString(
                    R.plurals.reviews,
                    model.reviewsCount,
                    model.reviewsCount
                )
                name.text = model.name
                duration.text = resources.getString(R.string.minutes, model.durationMinutes)
            }
        }
    }

    interface OnMovieClickListener {
        fun onLikeButtonClick(movieId: Int) {}
        fun onMovieItemClick(movieId: Int) {}
    }

}

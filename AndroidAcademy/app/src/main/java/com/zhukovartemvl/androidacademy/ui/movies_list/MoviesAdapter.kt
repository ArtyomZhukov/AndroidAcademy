package com.zhukovartemvl.androidacademy.ui.movies_list

import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.zhukovartemvl.androidacademy.R
import com.zhukovartemvl.androidacademy.databinding.ItemMovieBinding
import com.zhukovartemvl.androidacademy.ui.model.MovieView


class MoviesAdapter : ListAdapter<MovieView, MoviesAdapter.ViewHolder>(MovieItemDiffCallback()) {

    private var onLikeButtonClick: MovieItemCallback? = null

    fun attachCallback(callback: MovieItemCallback) {
        onLikeButtonClick = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onLikeButtonClick)
    }

    class ViewHolder(private val view: ItemMovieBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(item: MovieView, callback: MovieItemCallback?) {
            view.apply {
                val resources = root.context.resources

                root.setOnClickListener { callback?.onClick(item.id) }

                moviePreviewImage.load(item.previewImageURL) {
                    placeholder(R.drawable.placeholder_movie)
                    transformations(RoundedCornersTransformation(topLeft = 6.0f, topRight = 6.0f))
                }

                pg.textPG.text = item.pg

                likeButton.apply {
//                    setColorFilter(if (item.isFavorite) R.color.likeEnabled else R.color.likeDisabled)
                    val likeButtonColor = resources.getColor(if (item.isFavorite) R.color.likeEnabled else R.color.likeDisabled)
                    DrawableCompat.setTint(likeButton.drawable, likeButtonColor)
                    setOnClickListener {
                        callback?.onChangeFavorite(item.id, item.isFavorite.not())
                    }
                }

                tags.text = item.tags

                ratingBar.apply {
                    rating = item.rating
                    setOnRatingBarChangeListener { _, rating, fromUser ->
                        if (fromUser) callback?.onChangeRating(item.id, rating)
                    }
                }

                reviews.text = resources.getQuantityString(
                    R.plurals.reviews,
                    item.reviewsCount,
                    item.reviewsCount
                )
                name.text = item.name
                duration.text = resources.getString(R.string.minutes, item.durationMinutes)
            }
        }
    }

    interface MovieItemCallback {
        fun onClick(id: Int) {}
        fun onChangeFavorite(id: Int, isFavorite: Boolean) {}
        fun onChangeRating(id: Int, rating: Float) {}
    }

}

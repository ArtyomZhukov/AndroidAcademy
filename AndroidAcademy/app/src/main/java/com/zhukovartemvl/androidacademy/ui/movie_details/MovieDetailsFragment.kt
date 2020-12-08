package com.zhukovartemvl.androidacademy.ui.movie_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.zhukovartemvl.androidacademy.R
import com.zhukovartemvl.androidacademy.ui.utils.toActorItem
import com.zhukovartemvl.androidacademy.ui.utils.toMovieItem
import com.zhukovartemvl.androidacademy.data.repository.MovieRepository
import com.zhukovartemvl.androidacademy.databinding.FragmentMovieDetailsBinding


class MovieDetailsFragment : Fragment() {

    private val args by navArgs<MovieDetailsFragmentArgs>()

    private lateinit var binding: FragmentMovieDetailsBinding

    private val adapter = ActorsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inflater.inflate(R.layout.fragment_movie_details, container, false)
        binding = FragmentMovieDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val movie = args.movie.toMovieItem()
        val storyline = args.movie.storyline
        val actors = args.movie.actors.map { it.toActorItem() }.toMutableList()

        binding.apply {
            backButton.setOnClickListener { findNavController().popBackStack() }
            pg.textPG.text = movie.pg
            name.text = movie.name
            tags.text = movie.tags
            rating.apply {
                rating = movie.rating
                setOnRatingBarChangeListener { _, rating, fromUser ->
                    if (fromUser) MovieRepository.setRating(movie.id, rating)
                }
            }
            reviews.text = resources.getQuantityString(
                R.plurals.reviews,
                movie.reviewsCount,
                movie.reviewsCount
            )
            storylineContent.text = storyline
            actorsList.adapter = adapter
            adapter.submitList(actors)
        }
    }

}

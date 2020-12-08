package com.zhukovartemvl.androidacademy.ui.movies_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zhukovartemvl.androidacademy.R
import com.zhukovartemvl.androidacademy.data.repository.MovieRepository
import com.zhukovartemvl.androidacademy.ui.utils.toMovieItem
import com.zhukovartemvl.androidacademy.data.model.Movie
import com.zhukovartemvl.androidacademy.databinding.FragmentMoviesListBinding


class MoviesListFragment : Fragment() {

    private lateinit var binding: FragmentMoviesListBinding

    private val navController by lazy { findNavController() }

    private val adapter = MoviesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inflater.inflate(R.layout.fragment_movies_list, container, false)
        binding = FragmentMoviesListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.moviesList.adapter = adapter
        updateMoviesList()
        adapter.attachCallback(object : MoviesAdapter.MovieItemCallback {
            override fun onClick(id: Int) {
                val movie = MovieRepository.getMovieById(id)
                movie?.let { openMovieDetails(movie) }
            }

            override fun onChangeFavorite(id: Int, isFavorite: Boolean) {
                MovieRepository.setFavorite(id, isFavorite)
                updateMoviesList()
            }

            override fun onChangeRating(id: Int, rating: Float) {
                MovieRepository.setRating(id, rating)
                updateMoviesList()
            }
        })
    }

    private fun updateMoviesList() {
        val movies = MovieRepository.getAllMovies().map { it.toMovieItem() }
        adapter.submitList(movies)
    }

    private fun openMovieDetails(movie: Movie) {
        val action = MoviesListFragmentDirections.toMovieDetails(movie)
        navController.navigate(action)
    }

}

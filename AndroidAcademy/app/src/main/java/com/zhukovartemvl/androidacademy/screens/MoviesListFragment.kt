package com.zhukovartemvl.androidacademy.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zhukovartemvl.androidacademy.R
import com.zhukovartemvl.androidacademy.databinding.FragmentMoviesListBinding


class MoviesListFragment : Fragment() {

    private lateinit var binding: FragmentMoviesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_movies_list, container, false)
        binding = FragmentMoviesListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.sampleMovieItem.movieItemBase.setOnClickListener {
            findNavController().navigate(R.id.toMovieDetails)
        }
    }

}

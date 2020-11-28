package com.zhukovartemvl.androidacademy.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zhukovartemvl.androidacademy.R
import com.zhukovartemvl.androidacademy.databinding.FragmentMovieDetailsBinding
import com.zhukovartemvl.androidacademy.databinding.FragmentMoviesListBinding


class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_movie_details, container, false)
        binding = FragmentMovieDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}

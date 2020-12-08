package com.zhukovartemvl.androidacademy.data.repository

import com.zhukovartemvl.androidacademy.data.model.Actor
import com.zhukovartemvl.androidacademy.data.model.Movie


object MovieRepository {

    fun getMovieById(movieId: Int): Movie? = movies.getOrNull(movieId)

    fun getAllMovies(): List<Movie> = movies

    fun setFavorite(movieId: Int, isFavorite: Boolean) {
        getMovieById(movieId)?.let { movie -> movie.isFavorite = isFavorite }
    }

    fun setRating(movieId: Int, rating: Float) {
        getMovieById(movieId)?.let { movie -> movie.rating = rating }
    }

    private val movies = mutableListOf(
        Movie(
            id = 0,
            name = "Avengers: End Game",
            previewImageURL = "https://dl.dropbox.com/s/kkzgrow8j3ke0a1/AvengersEndGame.png?dl=0",
            backgroundImageURL = "",
            tags = listOf("Action", "Adventure", "Drama"),
            rating = 4.0f,
            durationMinutes = 137,
            reviewsCount = 125,
            storyline = "After the devastating events of Avengers: Infinity War, the universe " +
                    "is in ruins. With the help of remaining allies, the Avengers assemble " +
                    "once more in order to reverse Thanos\' actions and restore balance " +
                    "to the universe.",
            actors = listOf(
                Actor(
                    "Robert Downey Jr.",
                    "https://dl.dropbox.com/s/tuzmmrctsvelzkr/RobertDowneyJr.png?dl=0"
                ),
                Actor(
                    "Chris Evans",
                    "https://dl.dropbox.com/s/mkh4so6zdiyu4k9/ChrisEvans.png?dl=0"
                ),
                Actor(
                    "Mark Ruffalo",
                    "https://dl.dropbox.com/s/9mhb4gwr6qi9y9m/MarkRuffalo.png?dl=0"
                ),
                Actor(
                    "Chris Hemsworth",
                    "https://dl.dropbox.com/s/12mbi3lxxplukq8/ChrisHemsworth.png?dl=0"
                )
            ),
            pg = 13,
            isFavorite = false
        ),
        Movie(
            id = 1,
            name = "Tenet",
            previewImageURL = "https://dl.dropbox.com/s/nevvoen4etznl7w/Tenet.png?dl=0",
            backgroundImageURL = "",
            tags = listOf("Action", "Sci-Fi", "Thriller"),
            rating = 5.0f,
            durationMinutes = 97,
            reviewsCount = 0,
            storyline = "Tenet storyline",
            actors = listOf(
                Actor(
                    "Tenet Actor 1",
                    "https://dl.dropbox.com/s/tuzmmrctsvelzkr/RobertDowneyJr.png?dl=0"
                ),
                Actor(
                    "Tenet Actor 2",
                    "https://dl.dropbox.com/s/mkh4so6zdiyu4k9/ChrisEvans.png?dl=0"
                ),
                Actor(
                    "Tenet Actor 3",
                    "https://dl.dropbox.com/s/9mhb4gwr6qi9y9m/MarkRuffalo.png?dl=0"
                )
            ),
            pg = 16,
            isFavorite = true
        ),
        Movie(
            id = 2,
            name = "Black Widow",
            previewImageURL = "https://dl.dropbox.com/s/wkv9mmyttinvnag/BlackWidow.png?dl=0",
            backgroundImageURL = "",
            tags = listOf("Action", "Adventure", "Sci-Fi"),
            rating = 4.0f,
            durationMinutes = 102,
            reviewsCount = 1,
            storyline = "Black Widow storyline",
            actors = listOf(
                Actor(
                    "Black Widow Actor 1",
                    "https://dl.dropbox.com/s/tuzmmrctsvelzkr/RobertDowneyJr.png?dl=0"
                ),
                Actor(
                    "Black Widow Actor 2",
                    "https://dl.dropbox.com/s/mkh4so6zdiyu4k9/ChrisEvans.png?dl=0"
                ),
                Actor(
                    "Black Widow Actor 3",
                    "https://dl.dropbox.com/s/9mhb4gwr6qi9y9m/MarkRuffalo.png?dl=0"
                ),
                Actor(
                    "Black Widow Actor 4",
                    "https://dl.dropbox.com/s/12mbi3lxxplukq8/ChrisHemsworth.png?dl=0"
                ),
                Actor(
                    "Black Widow Actor 5",
                    "https://dl.dropbox.com/s/tuzmmrctsvelzkr/RobertDowneyJr.png?dl=0"
                )
            ),
            pg = 13,
            isFavorite = false
        ),
        Movie(
            id = 3,
            name = "Wonder Woman 1984",
            previewImageURL = "https://dl.dropbox.com/s/mn5fz01r8wjrktt/WonderWoman1984.png?dl=0",
            backgroundImageURL = "",
            tags = listOf("Action", "Adventure", "Fantasy"),
            rating = 5.0f,
            durationMinutes = 120,
            reviewsCount = 74,
            storyline = "Wonder Woman 1984 storyline",
            actors = listOf(
                Actor(
                    "Wonder Woman 1984 Actor 1",
                    "https://dl.dropbox.com/s/tuzmmrctsvelzkr/RobertDowneyJr.png?dl=0"
                ),
                Actor(
                    "Wonder Woman 1984 Actor 2",
                    "https://dl.dropbox.com/s/mkh4so6zdiyu4k9/ChrisEvans.png?dl=0"
                ),
                Actor(
                    "Wonder Woman 1984 Actor 3",
                    "https://dl.dropbox.com/s/9mhb4gwr6qi9y9m/MarkRuffalo.png?dl=0"
                ),
                Actor(
                    "Wonder Woman 1984 Actor 4",
                    "https://dl.dropbox.com/s/12mbi3lxxplukq8/ChrisHemsworth.png?dl=0"
                )
            ),
            pg = 13,
            isFavorite = false
        )
    )
}

package com.example.mufee.domain.model

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
data class DataMovieModel(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>?,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
)
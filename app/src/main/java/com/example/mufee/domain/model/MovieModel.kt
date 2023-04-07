package com.example.mufee.domain.model

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
data class MovieModel(
    val page: Int,
    val results: List<DataMovieModel>,
    val totalPages: Int,
    val totalResults: Int,
)
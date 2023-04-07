package com.example.mufee.ui.feature

import com.example.mufee.domain.model.DataMovieModel

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
data class MovieState(
    val movies: List<DataMovieModel>? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
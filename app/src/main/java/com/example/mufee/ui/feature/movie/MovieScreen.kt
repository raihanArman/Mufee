package com.example.mufee.ui.feature.movie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
@Composable
fun MovieScreen(
    viewModel: MovieViewModel = getViewModel()
) {
    val movieState by viewModel.observeMovieState.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
          text = "Movie state -> ${movieState.movies}"
        )
    }

}
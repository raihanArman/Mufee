package com.example.mufee.ui.feature.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mufee.ui.composables.ErrorText
import com.example.mufee.ui.composables.ProgressCircular
import com.example.mufee.ui.feature.movie.component.MovieItem
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
        LazyVerticalGrid(
            modifier = Modifier
                .padding(25.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            movieState.movies?.let { data ->
                if(data.isNotEmpty()) {
                    items(data) { movie ->
                        MovieItem(
                            image = movie.posterPath ,
                            title = movie.title
                        )
                    }
                } else {
                    item(span = { GridItemSpan(2) }) {
                        ErrorText(
                            modifier = Modifier.fillMaxSize(),
                            message = "Favorite is empty"
                        )
                    }
                }
            }

            if(movieState.isLoading) {
                item(span = { GridItemSpan(2) }) {
                    ProgressCircular(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }

}
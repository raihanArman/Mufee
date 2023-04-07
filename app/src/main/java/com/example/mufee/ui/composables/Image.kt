package com.example.mufee.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.SubcomposeAsyncImage
import com.example.mufee.R

/**
 * @author Raihan Arman
 * @date 08/04/23
 */
@Composable
fun BaseImageView(
    url: String,
    modifier: Modifier,
    contentScale: ContentScale? = null
) {
    SubcomposeAsyncImage(
        model = url,
        modifier = modifier,
        loading = {
            DefaultLoadingView()
        },
        error = {
            Image(painter = painterResource(id = R.drawable.ic_placeholder), contentDescription = null)
        },
        success = {
            Image(
                painter = this.painter, contentDescription = "",
                modifier = modifier,
                contentScale = contentScale ?: ContentScale.FillBounds,
            )
        },
        contentDescription = ""
    )
}

@Composable
fun DefaultLoadingView() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize(),
            color = MaterialTheme.colors.primary
        )
    }
}
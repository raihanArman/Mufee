package com.example.mufee.ui.feature.movie.di

import com.example.mufee.ui.feature.movie.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 08/04/23
 */
object MovieModule {
    fun modules() = module {
        viewModel { MovieViewModel(get()) }
    }
}
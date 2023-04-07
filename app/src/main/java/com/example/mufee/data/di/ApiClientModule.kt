package com.example.mufee.data.di

import com.example.mufee.data.source.remote.MovieApiClient
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
object ApiClientModule {
    fun modules() = module {
        single { MovieApiClient.build() }
    }
}
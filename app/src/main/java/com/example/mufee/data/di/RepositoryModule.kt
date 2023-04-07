package com.example.mufee.data.di

import com.example.mufee.data.repository.MovieRepository
import com.example.mufee.data.repository.MovieRepositoryImpl
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
object RepositoryModule {
    fun modules() = module {
        single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    }
}
package com.example.mufee.domain.di

import com.example.mufee.domain.usecase.GetMoviePopularUseCase
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
object UseCaseModule {
    fun modules() = module {
        factory { GetMoviePopularUseCase(get()) }
    }
}
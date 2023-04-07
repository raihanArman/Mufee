package com.example.mufee.domain.usecase

import com.example.mufee.data.repository.MovieRepository
import com.example.mufee.domain.model.MovieModel
import com.example.mufee.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
class GetMoviePopularUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke() = repository.getMoviePopular()
}
package com.example.mufee.data.repository

import com.example.mufee.data.mapper.MovieMapper
import com.example.mufee.data.source.remote.MovieApiClient
import com.example.mufee.domain.model.MovieModel
import com.example.mufee.utils.NetworkResource
import com.example.mufee.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
interface MovieRepository {
    suspend fun getMoviePopular(): Flow<Resource<MovieModel>>
}

class MovieRepositoryImpl(
    private val apiClient: MovieApiClient,
): MovieRepository {
    override suspend fun getMoviePopular(): Flow<Resource<MovieModel>> {
        return object : NetworkResource<MovieModel>() {
            override suspend fun remoteFetch(): MovieModel {
                val result = apiClient.getMoviePopular()
                return MovieMapper.mapToModel(result)
            }


        }.asFlow()
    }

}
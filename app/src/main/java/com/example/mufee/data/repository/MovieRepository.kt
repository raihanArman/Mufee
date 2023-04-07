package com.example.mufee.data.repository

import com.example.mufee.data.mapper.MovieMapper
import com.example.mufee.data.source.local.MovieDao
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
    private val dao: MovieDao,
): MovieRepository {
    override suspend fun getMoviePopular(): Flow<Resource<MovieModel>> {
        return object : NetworkResource<MovieModel>() {
            override suspend fun remoteFetch(): MovieModel {
                val result = apiClient.getMoviePopular()
                return MovieMapper.mapResponseToModel(result)
            }

            override suspend fun saveLocal(data: MovieModel) {
                dao.insertMovies(
                    data.results.map {
                        MovieMapper.mapModelToEntity(it)
                    }
                )
            }

            override fun shouldFetchRemoteAndSaveLocal(): Boolean {
                return true
            }

            override suspend fun localFetch(): MovieModel? {
                val fetchFromDb = dao.getMovies()
                return MovieMapper.mapEntityToModel(fetchFromDb)
            }

            override fun shouldFetchLocalOnError(): Boolean {
                return true
            }


        }.asFlow()
    }

}
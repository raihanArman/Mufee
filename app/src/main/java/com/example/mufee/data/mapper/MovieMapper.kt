package com.example.mufee.data.mapper

import com.example.mufee.data.entity.MovieEntity
import com.example.mufee.data.response.MovieResponse
import com.example.mufee.domain.model.DataMovieModel
import com.example.mufee.domain.model.MovieModel

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
object MovieMapper {
    fun mapResponseToModel(value: MovieResponse): MovieModel {
        return MovieModel(
            page = value.page ?: 0,
            results = value.results?.map {
                DataMovieModel(
                    id = it.id ?: 0,
                    originalTitle = it.originalTitle.orEmpty(),
                    posterPath = it.posterPath.orEmpty(),
                    title = it.title.orEmpty(),
                )
            } ?: emptyList(),
            totalPages = value.totalPages ?: 0,
            totalResults = value.totalResults ?: 0
        )
    }

    fun mapModelToEntity(value: DataMovieModel) = MovieEntity(
        id = value.id,
        title = value.originalTitle,
        poster = value.posterPath,
    )

    fun mapEntityToModel(value: List<MovieEntity>) = MovieModel(
        page = 0,
        results = value.map {
            DataMovieModel(
                id = it.id,
                originalTitle = it.title,
                posterPath = it.poster,
                title = it.title.orEmpty(),
            )
        },
        totalPages = 0,
        totalResults =  0
    )
}
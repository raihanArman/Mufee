package com.example.mufee.data.mapper

import com.example.mufee.data.response.MovieResponse
import com.example.mufee.domain.model.DataMovieModel
import com.example.mufee.domain.model.MovieModel

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
object MovieMapper {
    fun mapToModel(value: MovieResponse): MovieModel {
        return MovieModel(
            page = value.page ?: 0,
            results = value.results?.map {
                DataMovieModel(
                    adult = it.adult ?: false,
                    backdropPath = it.backdropPath.orEmpty(),
                    genreIds = it.genreIds,
                    id = it.id ?: 0,
                    originalLanguage = it.originalLanguage.orEmpty(),
                    originalTitle = it.originalTitle.orEmpty(),
                    overview = it.overview.orEmpty(),
                    popularity = it.popularity ?: 0.0,
                    posterPath = it.posterPath.orEmpty(),
                    releaseDate = it.releaseDate.orEmpty(),
                    title = it.title.orEmpty(),
                    video = it.video ?: false,
                    voteAverage = it.voteAverage ?: 0.0,
                )
            } ?: emptyList(),
            totalPages = value.totalPages ?: 0,
            totalResults = value.totalResults ?: 0
        )
    }
}
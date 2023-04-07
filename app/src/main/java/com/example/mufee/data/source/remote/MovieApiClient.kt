package com.example.mufee.data.source.remote

import com.example.mufee.data.response.MovieResponse
import com.example.mufee.libs.network.RetrofitBuilder
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Response
import retrofit2.create
import retrofit2.http.GET

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
interface MovieApiClient {
    @GET("/api/user")
    suspend fun getMoviePopular(): MovieResponse

    companion object: KoinComponent {
        private val retrofitBuilder: RetrofitBuilder by inject()

        fun build(): MovieApiClient {
            return retrofitBuilder.build().create()
        }
    }

}
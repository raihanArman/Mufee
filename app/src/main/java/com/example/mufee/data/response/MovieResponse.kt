package com.example.mufee.data.response

import com.google.gson.annotations.SerializedName

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
data class MovieResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<MovieResultResponse>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?,
)
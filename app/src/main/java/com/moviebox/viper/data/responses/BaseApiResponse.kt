package com.moviebox.viper.data.responses

import com.google.gson.annotations.SerializedName

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
data class BaseApiResponse<T>(
        @SerializedName("page") val page: Int,
        @SerializedName("total_results") val totalResults: Int,
        @SerializedName("total_pages") val totalPages: Int,
        @SerializedName("results") val results: List<T>
)
package com.moviebox.viper.data.responses

import com.google.gson.annotations.SerializedName

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
data class ErrorResponse(
        @SerializedName("status_code") val statusCode: Int,
        @SerializedName("status_message") val statusMessage: String
)
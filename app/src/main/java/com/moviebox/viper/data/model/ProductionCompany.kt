package com.moviebox.viper.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
data class ProductionCompany (
        @SerializedName("id") val id: Int,
        @SerializedName("logo_path") val logoPath: String,
        @SerializedName("name") val name: String,
        @SerializedName("origin_country") val originCountry: String
)
package com.moviebox.viper.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
data class ProductionCountry(
        @SerializedName("iso_3166_1") val iso31661: String,
        @SerializedName("name") val name: String
)
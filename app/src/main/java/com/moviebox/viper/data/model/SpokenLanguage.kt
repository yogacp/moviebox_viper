package com.moviebox.viper.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
data class SpokenLanguage(
        @SerializedName("iso_639_1") val iso6391: String,
        @SerializedName("name") val name: String
)
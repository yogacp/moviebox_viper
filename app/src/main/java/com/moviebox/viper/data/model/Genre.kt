package com.moviebox.viper.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
data class Genre (
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String
)
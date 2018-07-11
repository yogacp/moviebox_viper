package com.moviebox.viper.presentation.detailpage.usecase

import com.moviebox.viper.data.model.DetailsMovie
import com.moviebox.viper.data.responses.BaseApiResponse
import io.reactivex.Observable

/**
 * Created by Yoga C. Pranata on 11/07/2018.
 * Android Engineer
 */
interface DetailPageUseCase {
    fun loadDetailMovie(id: String) : Observable<DetailsMovie>
}
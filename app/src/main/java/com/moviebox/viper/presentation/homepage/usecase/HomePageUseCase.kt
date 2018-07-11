package com.moviebox.viper.presentation.homepage.usecase

import com.moviebox.viper.data.model.Result
import com.moviebox.viper.data.responses.BaseApiResponse
import io.reactivex.Observable

/**
 * Created by Yoga C. Pranata on 11/07/2018.
 * Android Engineer
 */
interface HomePageUseCase {
    fun getMovieListFromApi(reqPage: String, state: String) : Observable<BaseApiResponse<Result>>
}
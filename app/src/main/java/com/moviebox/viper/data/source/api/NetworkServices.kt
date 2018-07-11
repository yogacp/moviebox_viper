package com.moviebox.viper.data.source.api

import com.moviebox.viper.data.model.DetailsMovie
import com.moviebox.viper.data.model.Result
import com.moviebox.viper.data.responses.BaseApiResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
interface NetworkServices {
    @GET("movie/popular?language=en-US")
    fun getPopularMovies(@Query("page") page: String, @Query("api_key") api_key: String): Observable<BaseApiResponse<Result>>

    @GET("movie/{id}")
    fun getDetailsMovie(@Path("id") id: String, @Query("api_key")api_key: String): Observable<DetailsMovie>
}
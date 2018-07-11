package com.moviebox.viper.data.source

import com.moviebox.viper.BuildConfig
import com.moviebox.viper.data.model.DetailsMovie
import com.moviebox.viper.data.model.Result
import com.moviebox.viper.data.responses.BaseApiResponse
import com.moviebox.viper.data.source.api.NetworkServices
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
class MovieAppRepository @Inject constructor(var mNetworkServices: NetworkServices) {
    /**
     * Get Popular Movies
     */
    fun getPopularMovies(page: String): Observable<BaseApiResponse<Result>> {
        return mNetworkServices.getPopularMovies(page, BuildConfig.MOVIEDB_APIKEY)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * Get Details Movies
     */
    fun getDetailsMovies(id: String): Observable<DetailsMovie> {
        return mNetworkServices.getDetailsMovie(id, BuildConfig.MOVIEDB_APIKEY)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
    }
}

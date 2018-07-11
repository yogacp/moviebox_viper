package com.moviebox.viper.presentation.homepage.usecase

import com.moviebox.viper.data.model.Result
import com.moviebox.viper.data.responses.BaseApiResponse
import com.moviebox.viper.data.source.MovieAppRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 11/07/2018.
 * Android Engineer
 */
class HomePageInteractor @Inject constructor(val mRepository: MovieAppRepository) : HomePageUseCase {
    override fun getMovieListFromApi(reqPage: String, state: String): Observable<BaseApiResponse<Result>> {
        return mRepository.getPopularMovies(reqPage).flatMap {
            Observable.just(it)
        }
    }
}
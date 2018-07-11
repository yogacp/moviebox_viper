package com.moviebox.viper.presentation.detailpage.usecase

import com.moviebox.viper.data.model.DetailsMovie
import com.moviebox.viper.data.source.MovieAppRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 11/07/2018.
 * Android Engineer
 */
class DetailPageInteractor @Inject constructor(val mRepository: MovieAppRepository) : DetailPageUseCase {
    override fun loadDetailMovie(id: String): Observable<DetailsMovie> {
        return mRepository.getDetailsMovies(id).flatMap { Observable.just(it) }
    }
}
package com.moviebox.viper.presentation.homepage

import android.content.Context
import android.util.TypedValue
import com.moviebox.viper.baseapp.external.extentions.isNetworkConnected
import com.moviebox.viper.baseapp.presenter.BasePresenter
import com.moviebox.viper.domain.scheduler.SchedulerProvider
import com.moviebox.viper.presentation.homepage.HomePageActivity.Companion.REFRESH_DATA
import com.moviebox.viper.presentation.homepage.usecase.HomePageUseCase
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
class HomePagePresenter @Inject constructor(
        val mContext: Context,
        val useCase : HomePageUseCase,
        scheduler: SchedulerProvider
) : BasePresenter<HomePageContract.View>(scheduler), HomePageContract.Presenter {

    override fun getMovieList(reqPage: String, state: String) {
        view?.showProgressBar()
        view?.hideEmptyResult()
        view?.hideErrorResult()
        view?.hideOfflineView()

        if(mContext.isNetworkConnected()) {
            loadMovieList(reqPage, state)
        } else {
            view?.hideProgressBar()
            view?.hideEmptyResult()
            if(state.equals(REFRESH_DATA)) {
                view?.showErrorResult("Not Connected to Internet")
            } else {
                view?.showOfflineView()
            }
        }
    }


    override fun loadMovieList(reqPage: String, state: String) {
        addDisposable(useCase.getMovieListFromApi(reqPage, state)
                .subscribe({ response ->
                    view?.hideProgressBar()
                    if (response.results.size > 0) {
                        response.let {
                            view?.setMovieList(it.results, reqPage)
                            if(state.equals(REFRESH_DATA)) {
                                view?.setAdapter()
                            }
                        }
                    } else {
                        view?.showEmptyResult()
                    }
                }, { error ->
                    view?.hideProgressBar()
                    view?.hideEmptyResult()
                    if(state.equals(REFRESH_DATA)) {
                        view?.showErrorResult("Not Connected to Internet")
                    } else {
                        view?.showOfflineView()
                    }
                }))
    }

    override fun dpToPx(dp: Int): Int {
        val r = mContext.resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
    }

}
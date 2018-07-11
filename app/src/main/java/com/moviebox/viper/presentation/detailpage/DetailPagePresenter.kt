package com.moviebox.viper.presentation.detailpage

import android.content.Context
import com.moviebox.viper.baseapp.external.extentions.isNetworkConnected
import com.moviebox.viper.baseapp.presenter.BasePresenter
import com.moviebox.viper.domain.scheduler.SchedulerProvider
import com.moviebox.viper.presentation.detailpage.usecase.DetailPageUseCase
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
class DetailPagePresenter @Inject constructor(
        val mContext: Context,
        val useCase : DetailPageUseCase,
        scheduler: SchedulerProvider
) : BasePresenter<DetailPageContract.View>(scheduler), DetailPageContract.Presenter {

    override fun getDetailMovie(id: String) {
        if(mContext.isNetworkConnected()) {
            loadDetailMovie(id)
        } else {
            view?.showErrorResult("Not Connected to Internet")
        }
    }

    override fun loadDetailMovie(id: String) {
        addDisposable(useCase.loadDetailMovie(id)
                .subscribe({response ->
                    response.let {
                        view?.setupData(it)
                    }
                }, { error ->
                    view?.showErrorResult("Not Connected to Internet")
                }))
    }

}
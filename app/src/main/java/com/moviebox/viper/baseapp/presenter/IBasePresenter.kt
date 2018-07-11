package com.moviebox.viper.baseapp.presenter

import com.moviebox.viper.baseapp.view.BaseView

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
interface IBasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}
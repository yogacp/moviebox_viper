package com.moviebox.viper.baseapp.view

import com.moviebox.viper.baseapp.presenter.BasePresenter

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
interface BaseView{
    fun setPresenter(presenter: BasePresenter<*>)
}
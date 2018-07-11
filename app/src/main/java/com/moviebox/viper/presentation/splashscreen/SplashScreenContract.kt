package com.moviebox.viper.presentation.splashscreen

import com.moviebox.viper.baseapp.view.BaseView

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
class SplashScreenContract {

    interface View: BaseView {
        fun runSplashScreen(timeout: Long)
    }

    interface Router {
        fun goToHomePage()
    }
}
package com.moviebox.viper.domain.router

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
interface ScreenRouter {

    sealed class ActivityScreen {
        object HomePage : ActivityScreen()
        object DetailPage : ActivityScreen()
    }

    fun getScreenIntent(context: Context, screen: ActivityScreen): Intent?
}
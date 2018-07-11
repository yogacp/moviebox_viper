package com.moviebox.viper.presentation.splashscreen

import android.app.Activity
import android.content.Context
import android.support.v4.content.ContextCompat.startActivity
import com.moviebox.viper.domain.router.ScreenRouter
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 11/07/2018.
 * Android Engineer
 */
class SplashScreenRouter @Inject constructor(
        val mScreenRouter: ScreenRouter,
        val mContext: Context
): SplashScreenContract.Router {

    override fun goToHomePage() {
        mScreenRouter.getScreenIntent(mContext, ScreenRouter.ActivityScreen.HomePage)
                ?.run { mContext.startActivity(this) }
    }
}
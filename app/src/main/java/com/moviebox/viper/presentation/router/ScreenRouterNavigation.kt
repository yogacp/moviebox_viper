package com.moviebox.viper.presentation.router

import android.content.Context
import android.content.Intent
import com.moviebox.viper.domain.router.ScreenRouter
import com.moviebox.viper.presentation.detailpage.DetailPageActivity
import com.moviebox.viper.presentation.homepage.HomePageActivity

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
class ScreenRouterNavigation : ScreenRouter {
    override fun getScreenIntent(context: Context, screen: ScreenRouter.ActivityScreen): Intent? {
        val c: Class<*>? = when (screen) {
            ScreenRouter.ActivityScreen.HomePage -> HomePageActivity::class.java
            ScreenRouter.ActivityScreen.DetailPage -> DetailPageActivity::class.java
            else -> null
        }
        return if (c == null) null else Intent(context, c)
    }
}
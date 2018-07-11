package com.moviebox.viper.presentation.splashscreen.di

import android.content.Context
import com.moviebox.viper.baseapp.di.scope.ActivityScope
import com.moviebox.viper.domain.router.ScreenRouter
import com.moviebox.viper.presentation.splashscreen.SplashScreenActivity
import com.moviebox.viper.presentation.splashscreen.SplashScreenContract
import com.moviebox.viper.presentation.splashscreen.SplashScreenRouter
import dagger.Module
import dagger.Provides

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
@Module
class SplashScreenModule {
    @Provides @ActivityScope
    fun provideActivity(splashScreenActivity: SplashScreenActivity) : SplashScreenContract.View = splashScreenActivity

    @Provides @ActivityScope
    fun provideRouter(screenRouter: ScreenRouter, context: Context) : SplashScreenRouter {
        return SplashScreenRouter(screenRouter, context)
    }
}
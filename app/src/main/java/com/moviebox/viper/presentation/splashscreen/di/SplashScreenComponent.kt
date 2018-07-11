package com.moviebox.viper.presentation.splashscreen.di

import com.moviebox.viper.baseapp.di.scope.ActivityScope
import com.moviebox.viper.presentation.splashscreen.SplashScreenActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
@ActivityScope
@Subcomponent(modules = [(SplashScreenModule::class)])
interface SplashScreenComponent : AndroidInjector<SplashScreenActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SplashScreenActivity>()
}
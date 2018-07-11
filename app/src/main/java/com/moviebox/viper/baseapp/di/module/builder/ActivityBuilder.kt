package com.moviebox.viper.baseapp.di.module.builder

import android.app.Activity
import com.moviebox.viper.presentation.detailpage.DetailPageActivity
import com.moviebox.viper.presentation.detailpage.di.DetailPageComponent
import com.moviebox.viper.presentation.homepage.HomePageActivity
import com.moviebox.viper.presentation.homepage.di.HomePageComponent
import com.moviebox.viper.presentation.splashscreen.SplashScreenActivity
import com.moviebox.viper.presentation.splashscreen.di.SplashScreenComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
@Module
abstract class ActivityBuilder {
    @Binds
    @IntoMap
    @ActivityKey(SplashScreenActivity::class)
    internal abstract fun bindSplashScreenActivity(builder: SplashScreenComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(HomePageActivity::class)
    internal abstract fun bindHomePageActivity(builder: HomePageComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(DetailPageActivity::class)
    internal abstract fun bindDetailPageActivity(builder: DetailPageComponent.Builder): AndroidInjector.Factory<out Activity>
}
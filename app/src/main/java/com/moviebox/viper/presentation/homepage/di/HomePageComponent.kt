package com.moviebox.viper.presentation.homepage.di

import com.moviebox.viper.baseapp.di.scope.ActivityScope
import com.moviebox.viper.presentation.homepage.HomePageActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
@ActivityScope
@Subcomponent(modules = [(HomePageModule::class)])
interface HomePageComponent : AndroidInjector<HomePageActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomePageActivity>()
}
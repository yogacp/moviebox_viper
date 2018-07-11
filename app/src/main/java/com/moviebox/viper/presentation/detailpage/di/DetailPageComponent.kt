package com.moviebox.viper.presentation.detailpage.di

import com.moviebox.viper.baseapp.di.scope.ActivityScope
import com.moviebox.viper.presentation.detailpage.DetailPageActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
@ActivityScope
@Subcomponent(modules = [(DetailPageModule::class)])
interface DetailPageComponent : AndroidInjector<DetailPageActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DetailPageActivity>()
}
package com.moviebox.viper.baseapp.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.moviebox.viper.baseapp.di.scope.AppScope
import com.moviebox.viper.domain.router.ScreenRouter
import com.moviebox.viper.domain.scheduler.AppSchedulerProvider
import com.moviebox.viper.baseapp.external.helper.Helper
import com.moviebox.viper.presentation.detailpage.di.DetailPageComponent
import com.moviebox.viper.presentation.homepage.di.HomePageComponent
import com.moviebox.viper.presentation.router.ScreenRouterNavigation
import com.moviebox.viper.presentation.splashscreen.di.SplashScreenComponent
import dagger.Module
import dagger.Provides

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
@Module(subcomponents = [
    (SplashScreenComponent::class),
    (HomePageComponent::class),
    (DetailPageComponent::class)
])
class AppModule {
    @Provides @AppScope
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides @AppScope
    internal fun gson(): Gson {
        return Gson()
    }

    @Provides @AppScope
    internal fun provideHelper(): Helper {
        return Helper()
    }

    @Provides @AppScope
    fun provideScreenRouter(): ScreenRouter = ScreenRouterNavigation()

    @Provides @AppScope
    fun provideSchedulerProvider() = AppSchedulerProvider()
}
package com.moviebox.viper.presentation.homepage.di

import android.content.Context
import com.moviebox.viper.baseapp.di.scope.ActivityScope
import com.moviebox.viper.data.source.MovieAppRepository
import com.moviebox.viper.domain.router.ScreenRouter
import com.moviebox.viper.domain.scheduler.AppSchedulerProvider
import com.moviebox.viper.presentation.homepage.HomePageActivity
import com.moviebox.viper.presentation.homepage.HomePageContract
import com.moviebox.viper.presentation.homepage.HomePagePresenter
import com.moviebox.viper.presentation.homepage.HomePageRouter
import com.moviebox.viper.presentation.homepage.usecase.HomePageInteractor
import com.moviebox.viper.presentation.homepage.usecase.HomePageUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
@Module
class HomePageModule {
    @Provides @ActivityScope
    fun provideActivity(homePageActivity: HomePageActivity) : HomePageContract.View = homePageActivity

    @Provides @ActivityScope
    fun provideRouter(screenRouter: ScreenRouter, context: Context) : HomePageRouter {
        return HomePageRouter(screenRouter, context)
    }

    @Provides @ActivityScope
    fun provideUseCase(repository: MovieAppRepository) : HomePageUseCase = HomePageInteractor(repository)

    @Provides @ActivityScope
    fun providePresenter(context: Context, useCase: HomePageUseCase, schedulerProvider: AppSchedulerProvider) : HomePagePresenter {
        return HomePagePresenter(context, useCase, schedulerProvider)
    }
}
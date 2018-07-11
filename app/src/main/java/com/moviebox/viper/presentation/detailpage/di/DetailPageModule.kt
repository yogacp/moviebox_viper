package com.moviebox.viper.presentation.detailpage.di

import android.content.Context
import com.moviebox.viper.baseapp.di.scope.ActivityScope
import com.moviebox.viper.data.source.MovieAppRepository
import com.moviebox.viper.domain.router.ScreenRouter
import com.moviebox.viper.domain.scheduler.AppSchedulerProvider
import com.moviebox.viper.domain.scheduler.SchedulerProvider
import com.moviebox.viper.presentation.detailpage.DetailPageActivity
import com.moviebox.viper.presentation.detailpage.DetailPageContract
import com.moviebox.viper.presentation.detailpage.DetailPagePresenter
import com.moviebox.viper.presentation.detailpage.usecase.DetailPageInteractor
import com.moviebox.viper.presentation.detailpage.usecase.DetailPageUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
@Module
class DetailPageModule {
    @Provides @ActivityScope
    fun provideActivity(detailPageActivity: DetailPageActivity) : DetailPageContract.View = detailPageActivity

    @Provides @ActivityScope
    fun provideUseCase(repository: MovieAppRepository) : DetailPageUseCase = DetailPageInteractor(repository)

    @Provides @ActivityScope
    fun providePresenter(context: Context, useCase: DetailPageUseCase, schedulerProvider: AppSchedulerProvider) : DetailPagePresenter {
        return DetailPagePresenter(context, useCase, schedulerProvider)
    }
}
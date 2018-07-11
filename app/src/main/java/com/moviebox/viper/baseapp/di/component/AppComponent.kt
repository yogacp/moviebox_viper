package com.moviebox.viper.baseapp.di.component

import android.app.Application
import com.moviebox.viper.MovieApp
import com.moviebox.viper.baseapp.di.module.AppModule
import com.moviebox.viper.baseapp.di.module.NetworkModule
import com.moviebox.viper.baseapp.di.module.builder.ActivityBuilder
import com.moviebox.viper.baseapp.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
@AppScope
@Component(modules = [
    (AndroidInjectionModule::class),
    (ActivityBuilder::class),
    (AppModule::class),
    (NetworkModule::class)
])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: MovieApp)
}
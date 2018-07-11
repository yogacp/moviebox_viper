package com.moviebox.viper.baseapp.di.module

import com.moviebox.viper.BuildConfig
import com.moviebox.viper.MovieApp
import com.moviebox.viper.data.source.api.NetworkServices
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
@Module
class NetworkModule(val movieApp: MovieApp) {
    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        val httpCacheDirectory = File(movieApp.cacheDir, "httpCache")
        val cache = Cache(httpCacheDirectory, 10 * 1024 * 1024)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor { chain ->
                    try {
                        chain.proceed(chain.request())
                    } catch (e: Exception) {
                        val offlineRequest = chain.request().newBuilder()
                                .header("Cache-Control", "public, only-if-cached," +
                                        "max-stale=" + 60 * 60 * 24)
                                .build()
                        chain.proceed(offlineRequest)
                    }
                }
                .cache(cache)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Named("moviebox_rest")
    fun provideRestClient(okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
        builder.client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
        return builder.build()
    }

    @Provides
    fun provideBeningmartNetworkService(@Named("moviebox_rest") restAdapter: Retrofit): NetworkServices {
        return restAdapter.create<NetworkServices>(NetworkServices::class.java)
    }
}
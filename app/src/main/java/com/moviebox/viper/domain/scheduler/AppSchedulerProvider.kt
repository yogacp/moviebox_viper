package com.moviebox.viper.domain.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
class AppSchedulerProvider : SchedulerProvider {
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
    override fun computation(): Scheduler = Schedulers.computation()
    override fun io(): Scheduler = Schedulers.io()
    override fun mainThread(): Scheduler = AndroidSchedulers.mainThread()
}
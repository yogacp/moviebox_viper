package com.moviebox.viper.domain.scheduler

import io.reactivex.Scheduler

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
interface SchedulerProvider {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun io(): Scheduler
    fun mainThread() : Scheduler
}
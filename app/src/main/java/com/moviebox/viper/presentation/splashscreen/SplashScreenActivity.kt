package com.moviebox.viper.presentation.splashscreen

import android.os.Bundle
import android.os.Handler
import com.moviebox.viper.R
import com.moviebox.viper.baseapp.activity.BaseActivity
import com.moviebox.viper.domain.router.ScreenRouter
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
class SplashScreenActivity : BaseActivity(), SplashScreenContract.View {

    @Inject
    lateinit var mRouter : SplashScreenRouter

    val LOG_TAG = "SplashScreen"
    val SPLASH_TIMEOUT = 1000 // 1 seconds timeout

    override fun onActivityReady(savedInstanceState: Bundle?) {
        runSplashScreen(SPLASH_TIMEOUT.toLong())
    }

    override fun onAutoAndroidInjector() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splashscreen
    }

    override fun runSplashScreen(timeout: Long) {
        Handler().postDelayed({
            kotlin.run {
                mRouter.goToHomePage()
                finish()
            }
        }, timeout)
    }
}
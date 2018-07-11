package com.moviebox.viper.baseapp.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.moviebox.viper.baseapp.external.helper.Helper
import com.moviebox.viper.baseapp.presenter.BasePresenter
import com.moviebox.viper.baseapp.view.BaseView
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
abstract class BaseActivity: AppCompatActivity(), BaseView {

    @Inject
    lateinit var mHelper: Helper

    @Inject
    lateinit var mGson: Gson

    private var presenter: BasePresenter<*>? = null

    /**
     * This function replace onCreate as main function run in activity
     * Auto Dependency Injection
     * @param Bundle
     * */

    abstract fun onActivityReady(savedInstanceState: Bundle?)

    abstract fun onAutoAndroidInjector()

    /**
     * Getting Layout ID from activity
     * */

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        onAutoAndroidInjector()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        onActivityReady(savedInstanceState)
    }

    override fun setPresenter(presenter: BasePresenter<*>) {
        this.presenter = presenter
    }

}
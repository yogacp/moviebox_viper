package com.moviebox.viper.presentation.homepage

import android.widget.ImageView
import com.moviebox.viper.baseapp.view.BaseView
import com.moviebox.viper.data.model.Result

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
class HomePageContract {
    interface View : BaseView {
        fun loadMovieList()
        fun clearMovieList()
        fun setMovieList(resultList: List<Result>, page: String)
        fun setAdapter()
        fun loadImageToImageView(mImagesUrl: String, imgView: ImageView)
        fun setupUIListener()
        fun showProgressBar()
        fun hideProgressBar()
        fun showEmptyResult()
        fun hideEmptyResult()
        fun showOfflineView()
        fun hideOfflineView()
        fun showErrorResult(message: String)
        fun hideErrorResult()
        fun showExitPopup()
        fun exitApp()
    }

    interface Presenter {
        fun getMovieList(reqPage: String, state: String)
        fun loadMovieList(reqPage: String, state: String)
        fun dpToPx(dp: Int) : Int
    }

    interface Router {
        fun goToDetailPage(id: String)
    }
}
package com.moviebox.viper.presentation.detailpage

import android.widget.ImageView
import com.moviebox.viper.baseapp.view.BaseView
import com.moviebox.viper.data.model.DetailsMovie

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
class DetailPageContract {
    interface View : BaseView {
        fun setupUI()
        fun showErrorResult(message: String)
        fun setupData(result: DetailsMovie?)
        fun loadImageToImageView(mImagesUrl: String, imgView: ImageView)
    }

    interface Presenter {
        fun getDetailMovie(id: String)
        fun loadDetailMovie(id: String)
    }
}
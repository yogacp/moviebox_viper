package com.moviebox.viper.presentation.detailpage

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import com.moviebox.viper.R
import com.moviebox.viper.baseapp.activity.BaseActivity
import com.moviebox.viper.baseapp.external.constants.AppConstant
import com.moviebox.viper.data.model.DetailsMovie
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.fragment_detail_movie.*
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
class DetailPageActivity : BaseActivity(), DetailPageContract.View {

    @Inject
    lateinit var mPresenter: DetailPagePresenter

    var mMoviesId = ""

    companion object {
        val TAG_MOVIES_ID = "movies_id"
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onAutoAndroidInjector() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_detail_movie
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        mPresenter.attachView(this)
        val bundle = intent.extras
        if (bundle != null) {
            if (bundle.containsKey(TAG_MOVIES_ID)) {
                mMoviesId = bundle.getString(TAG_MOVIES_ID)
                mPresenter.getDetailMovie(mMoviesId)
            }
        }
        setupUI()
    }

    override fun setupUI() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun showErrorResult(message: String) {
        toast(message)
    }

    override fun setupData(result: DetailsMovie?) {
        result?.let {
            collapsingToolbar.title = it.title.capitalize()
            collapsingToolbar.setExpandedTitleColor(resources.getColor(android.R.color.transparent))
            loadImageToImageView(AppConstant.BASE_IMAGE.URL_IMAGE_BACKDROP + "/w1280/" + it.backdropPath,imageMovie)
            detailMovieReleaseDate.setText(it.releaseDate)
            detailMovieCountAverage.setText("${it.voteAverage} / 10")
            detailMovieTitle.setText(it.title.capitalize())
            detailMovieDescription.setText(it.overview)

            var genres = ""
            for(genre in it.genres) {
                genres += "- " + genre.name + "\n"
            }

            detailMovieGenre.setText(genres)
        }
    }

    override fun loadImageToImageView(mImagesUrl: String, imgView: ImageView) {
        Picasso.get()
                .load(Uri.parse(mImagesUrl))
                .placeholder(R.drawable.progressbar)
                .fit()
                .centerInside()
                .into(imgView)
    }
}
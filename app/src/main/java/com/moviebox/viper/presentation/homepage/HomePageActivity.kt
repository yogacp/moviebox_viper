package com.moviebox.viper.presentation.homepage

import android.net.Uri
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.moviebox.viper.R
import com.moviebox.viper.baseapp.activity.BaseActivity
import com.moviebox.viper.baseapp.external.constants.AppConstant
import com.moviebox.viper.baseapp.external.extentions.showPopupDialog
import com.moviebox.viper.baseapp.external.helper.CallbackDialogInterface
import com.moviebox.viper.data.model.Result
import com.moviebox.viper.domain.adapter.setUp
import com.moviebox.viper.domain.infinitescroll.InfiniteScrollListener
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.item_movie_list.view.*
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
class HomePageActivity : BaseActivity(), HomePageContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var mPresenter: HomePagePresenter

    @Inject
    lateinit var mRouter: HomePageRouter

    var reqPage = 1
    var mMovieList = ArrayList<Result>()

    lateinit var mLayoutManager : RecyclerView.LayoutManager
    lateinit var mScrollViewListener : InfiniteScrollListener

    companion object {
        val REFRESH_DATA = "refresh_data"
        val LOAD_MORE_DATA = "load_more_data"
    }

    override fun onAutoAndroidInjector() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        mPresenter.attachView(this)
        setupUIListener()
        loadMovieList()
    }

    override fun onBackPressed() {
        showExitPopup()
    }

    override fun loadMovieList() {
        clearMovieList()
        mPresenter.getMovieList(reqPage.toString(), REFRESH_DATA)
    }

    override fun clearMovieList() {
        mMovieList.clear()
    }

    override fun setMovieList(resultList: List<Result>, page: String) {
        for(result in resultList) {
            mMovieList.add(result)
        }
    }

    override fun setAdapter() {
        rvUserList.addOnScrollListener(mScrollViewListener)
        rvUserList.setUp(
                mMovieList,
                R.layout.item_movie_list,
                {
                    loadImageToImageView(AppConstant.BASE_IMAGE.URL_IMAGE + it.posterPath,imgMovies)
                    tvMoviesTitle.text = it.title.capitalize()
                    tvMoviesReleaseDate.text = "Release Date: ${it.releaseDate}"
                },
                {
                    mRouter.goToDetailPage(it.id.toString())
                },
                mLayoutManager
        )
    }

    override fun loadImageToImageView(mImagesUrl: String, imgView: ImageView) {
        Picasso.get()
                .load(Uri.parse(mImagesUrl))
                .placeholder(R.drawable.progressbar)
                .fit()
                .centerInside()
                .into(imgView)
    }

    override fun setupUIListener() {
        homeSwipeLayout.setOnRefreshListener(this)
        mLayoutManager = GridLayoutManager(applicationContext, 2)
        llOfflineView.setOnClickListener {
            mPresenter.getMovieList(reqPage.toString(), LOAD_MORE_DATA)
        }

        mScrollViewListener = object : InfiniteScrollListener(mLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                reqPage = page + 1
                mPresenter.getMovieList(reqPage.toString(), LOAD_MORE_DATA)

                val cursize = rvUserList.adapter.itemCount
                view.post(object : Runnable{
                    override fun run() {
                        rvUserList.adapter.notifyItemRangeInserted(cursize, mMovieList.size - 1)
                    }
                })
            }
        }
    }

    override fun showEmptyResult() {
        rlEmptyUserList.visibility = View.VISIBLE
    }

    override fun showErrorResult(message: String) {
        rlErrorUserList.visibility = View.VISIBLE
    }

    override fun showProgressBar() {
        avLoadingIndicator.visibility = View.VISIBLE
    }

    override fun hideEmptyResult() {
        rlEmptyUserList.visibility = View.GONE
    }

    override fun hideErrorResult() {
        rlErrorUserList.visibility = View.GONE
    }

    override fun hideProgressBar() {
        avLoadingIndicator.visibility = View.GONE
    }

    override fun showOfflineView() {
        toast("Not Connected to Internet")
        llOfflineView.visibility = View.VISIBLE
    }

    override fun hideOfflineView() {
        llOfflineView.visibility = View.GONE
    }

    override fun showExitPopup() {
        val source = "2"
        val btnPositive = "Yes"
        val btnNegative = "Cancel"

        showPopupDialog {
            title = "Confirmation"
            message = "Do you want to close this application?"
            dialogSource = source
            positiveButton = btnPositive
            negativeButton = btnNegative
            callbackDialog = object : CallbackDialogInterface {
                override fun onButtonPositiveClicked() {
                    exitApp()
                }

                override fun onButtonNegativeClicked() {

                }
            }
        }
    }

    override fun exitApp() {
        finishAffinity()
        System.exit(0)
    }

    override fun onRefresh() {
        homeSwipeLayout.isRefreshing = false
        loadMovieList()
    }
}
package com.moviebox.viper.presentation.homepage

import android.content.Context
import com.moviebox.viper.domain.router.ScreenRouter
import com.moviebox.viper.presentation.detailpage.DetailPageActivity.Companion.TAG_MOVIES_ID
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 11/07/2018.
 * Android Engineer
 */
class HomePageRouter @Inject constructor(
        val mScreenRouter: ScreenRouter,
        val mContext: Context
) : HomePageContract.Router {

    override fun goToDetailPage(id: String) {
        mScreenRouter.getScreenIntent(mContext,ScreenRouter.ActivityScreen.DetailPage).apply {
            this!!.putExtra(TAG_MOVIES_ID,id)
        }?.run { mContext.startActivity(this) }
    }
}
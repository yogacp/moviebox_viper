package com.moviebox.viper.baseapp.external.extentions

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviebox.viper.R
import com.moviebox.viper.data.functionparameters.ShowDialogParams

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
infix fun ViewGroup.inflate(layoutResId: Int): View =
        LayoutInflater.from(context).inflate(layoutResId, this, false)


/**
 * Checking network state
 * @return boolean
 * */

fun Context.isNetworkConnected(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}


/**
 * Show Popup Dialog
 */

fun Context.showPopupDialog(input: ShowDialogParams.() -> Unit) {
    val params = ShowDialogParams().apply(input)
    params.let {
        val alertDialog: AlertDialog? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            AlertDialog.Builder(this, R.style.MovieBoxDialog).create()
        } else {
            AlertDialog.Builder(this).create()
        }

        alertDialog?.setTitle(it.title)
        alertDialog?.setMessage(it.message)
        alertDialog!!.setCancelable(false)

        if (it.dialogSource == "1") {
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, it.positiveButton, { _, _ ->
                it.callbackDialog!!.onButtonPositiveClicked()
            })
        } else {
            with(alertDialog) {
                setButton(AlertDialog.BUTTON_POSITIVE, it.positiveButton, { _, _ ->
                    it.callbackDialog!!.onButtonPositiveClicked()
                })

                setButton(AlertDialog.BUTTON_NEGATIVE, it.negativeButton, { _, _ ->
                    it.callbackDialog!!.onButtonNegativeClicked()
                })
            }
        }

        alertDialog.show()
    }
}
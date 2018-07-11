package com.moviebox.viper.data.functionparameters

import com.moviebox.viper.baseapp.external.helper.CallbackDialogInterface

/**
 * Created by Yoga C. Pranata on 10/07/2018.
 * Android Engineer
 */
data class ShowDialogParams(
        var title: String? = null,
        var message: String? = null,
        var dialogSource: String? = null,
        var positiveButton: String? = null,
        var negativeButton: String? = null,
        var callbackDialog: CallbackDialogInterface? = null
)
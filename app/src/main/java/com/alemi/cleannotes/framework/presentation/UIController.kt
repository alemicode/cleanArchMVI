package com.alemi.cleannotes.framework.presentation

import com.alemi.cleannotes.business.domain.state.DialogInputCaptureCallback
import com.alemi.cleannotes.business.domain.state.Response
import com.alemi.cleannotes.business.domain.state.StateMessageCallback


interface UIController {

    fun displayProgressBar(isDisplayed: Boolean)

    fun hideSoftKeyboard()

    fun displayInputCaptureDialog(title: String, callback: DialogInputCaptureCallback)

    fun onResponseReceived(
        response: Response,
        stateMessageCallback: StateMessageCallback
    )

}



















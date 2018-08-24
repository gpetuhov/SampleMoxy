package com.gpetuhov.android.samplemoxy.presentation.view

import com.arellomobile.mvp.MvpView

// This is the interface, that our view (MainActivity) must implement.
// Presenter calls methods of this interface.
interface MainView : MvpView {
    fun showProgress()
    fun hideProgress()
    fun showMessage(message: String)
    fun onError(errorMessage: String)
}
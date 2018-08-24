package com.gpetuhov.android.samplemoxy.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gpetuhov.android.samplemoxy.presentation.view.MainView

// This is the presenter for our MainActivity
// ALL (!!!) changes in MainActivity must be performed through this presenter ONLY!
@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    fun showMessage() {
        // We must call MainView's methods not directly, but through ViewState only.
        // This way Moxy will remember current state of the view and will restore it,
        // when the view is recreated.

        viewState.showProgress()
        Thread.sleep( 5000 )

        // TODO: This must go inside model
        viewState.showMessage("Dummy data")

        // TODO: Don't forget about onError

        viewState.hideProgress()
    }
}
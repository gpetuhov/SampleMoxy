package com.gpetuhov.android.samplemoxy.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gpetuhov.android.samplemoxy.model.MessageModel
import com.gpetuhov.android.samplemoxy.presentation.view.MainView

// This is the presenter for our MainActivity
// ALL (!!!) changes in MainActivity must be performed through this presenter ONLY!
@InjectViewState
class MainPresenter : MvpPresenter<MainView>(), MessageModel.Callback {

    private val messageModel: MessageModel = MessageModel(this)

    fun showMessage() {
        // We must call MainView's methods not directly, but through ViewState only.
        // This way Moxy will remember current state of the view and will restore it,
        // when the view is recreated.
        viewState.showProgress()

        // All data providing operations must go inside Model
        messageModel.getMessage()
    }

    override fun onSuccess(message: String) {
        viewState.hideProgress()
        viewState.showMessage(message)
    }

    override fun onError(errorMessage: String) {
        viewState.hideProgress()
        viewState.onError(errorMessage)
    }
}
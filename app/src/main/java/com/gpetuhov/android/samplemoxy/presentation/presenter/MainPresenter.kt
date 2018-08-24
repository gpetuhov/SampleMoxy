package com.gpetuhov.android.samplemoxy.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gpetuhov.android.samplemoxy.domain.interactor.ShowMessageInteractor
import com.gpetuhov.android.samplemoxy.domain.model.Message
import com.gpetuhov.android.samplemoxy.presentation.view.MainView
import com.gpetuhov.android.samplemoxy.repository.RepositoryImpl

// This is the presenter for our MainActivity
// ALL (!!!) changes in MainActivity must be performed through this presenter ONLY!
@InjectViewState
class MainPresenter : MvpPresenter<MainView>(), ShowMessageInteractor.Callback {

    // Here we instantiate Repository and ShowMessageInteractor directly,
    // but it is better to use Dagger.
    private val repository = RepositoryImpl()
    private val showMessageInteractor = ShowMessageInteractor(this, repository)

    fun showMessage() {
        // We must call MainView's methods not directly, but through ViewState only.
        // This way Moxy will remember current state of the view and will restore it,
        // when the view is recreated.
        viewState.showProgress()
        showMessageInteractor.execute()
    }

    override fun onSuccess(message: Message) {
        viewState.hideProgress()
        viewState.showMessage(message.text)
    }

    override fun onError(errorMessage: String) {
        viewState.hideProgress()
        viewState.onError(errorMessage)
    }
}
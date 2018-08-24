package com.gpetuhov.android.samplemoxy.ui.activity

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.gpetuhov.android.samplemoxy.R
import com.gpetuhov.android.samplemoxy.presentation.presenter.MainPresenter
import com.gpetuhov.android.samplemoxy.presentation.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast

// Main Activity must extend MvpActivity and implement our MainView interface
class MainActivity : MvpActivity(), MainView {

    // Here the presenter is injected into MainActivity.
    // When using Kotlin, the presenter must be initialized with lateinit.
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showMessageButton.setOnClickListener { onShowMessageButton() }
    }

    private fun onShowMessageButton() {
        // Whatever we do, we must do it through the presenter only.
        // The view must NOT change itself, only presenter can do it!
        doAsync { mainPresenter.showMessage() }
    }

    override fun showProgress() {
        runOnUiThread { progressBar.visibility = View.VISIBLE }
    }

    override fun hideProgress() {
        runOnUiThread { progressBar.visibility = View.GONE }
    }

    override fun showMessage(message: String) {
        runOnUiThread { messageTextView.text = message }
    }

    override fun onError(errorMessage: String) {
        runOnUiThread { toast(errorMessage) }
    }
}

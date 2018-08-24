package com.gpetuhov.android.samplemoxy.model

// Model is responsible for providing data to the presenter
class MessageModel(var callback: Callback) {

    // Model communicates with MainPresenter through this callback
    interface Callback {
        fun onSuccess(message: String)
        fun onError(errorMessage: String)
    }

    fun getMessage() {
        // Here we imitate long-running operation of retrieving data
        Thread.sleep(5000)

        val message = "Dummy data"

        if (message.equals("")) {
            callback.onError("Error getting data")
        } else {
            callback.onSuccess(message)
        }
    }
}
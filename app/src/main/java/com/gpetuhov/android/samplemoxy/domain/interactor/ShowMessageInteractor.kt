package com.gpetuhov.android.samplemoxy.domain.interactor

import com.gpetuhov.android.samplemoxy.domain.model.Message
import com.gpetuhov.android.samplemoxy.domain.repository.Repository

// This is the use case for the show message button.
// It consists of 4 actions:
// 1. Load message from the repository
// 2. Do some calculations and modify the message
// 3. Save result to the repository
// 4. Show result in the UI

// This class knows nothing of the Android specific classes
class ShowMessageInteractor(val callback: Callback, val repository: Repository) : Interactor {

    // Interactors communicate with outer layers through callbacks
    interface Callback {
        fun onSuccess(message: Message)
        fun onError(errorMessage: String)
    }

    override fun execute() {
        var message = repository.getMessage()

        if (message.isEmpty) {
            callback.onError("Error getting message")
            return
        }

        message = someVeryImportantCalculations(message)

        if (message.isEmpty) {
            callback.onError("Error calculating message")
            return
        }

        repository.saveMessage(message)
        callback.onSuccess(message)
    }

    private fun someVeryImportantCalculations(message: Message): Message {
        Thread.sleep(3000)
        message.text += " with calculation result"
        return message
    }
}
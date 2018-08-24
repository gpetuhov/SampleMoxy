package com.gpetuhov.android.samplemoxy.repository

import com.gpetuhov.android.samplemoxy.domain.model.Message
import com.gpetuhov.android.samplemoxy.domain.repository.Repository

// This is storage layer.
// All Android-specific code related to data retrieval and save goes here.
class RepositoryImpl : Repository {

    override fun getMessage(): Message {
        Thread.sleep(1000)
        return Message("Dummy data")
    }

    override fun saveMessage(message: Message) {
        Thread.sleep(1000)
    }
}
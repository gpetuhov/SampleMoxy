package com.gpetuhov.android.samplemoxy.domain.repository

import com.gpetuhov.android.samplemoxy.domain.model.Message

// At domain layer (business logic layer) we have only interface of the repository.
// All classes at this layer call methods of this interface to retrieve and save data.
// The interface must be implemented at the storage (outer) layer.
interface Repository {
    fun getMessage(): Message
    fun saveMessage(message: Message)
}
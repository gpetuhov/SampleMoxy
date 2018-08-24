package com.gpetuhov.android.samplemoxy.domain.model

// This is our message model
class Message(var text: String) {
    val isEmpty get() = text == ""
}
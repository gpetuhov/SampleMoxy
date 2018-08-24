package com.gpetuhov.android.samplemoxy.domain.model

// This is our message model.
// It's just a POJO for keeping data.
class Message(var text: String) {
    val isEmpty get() = text == ""
}
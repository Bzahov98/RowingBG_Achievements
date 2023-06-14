package com.bzahov.rowingbg.achievements.ui.activities.auth

interface AuthListener {
    fun onStarted()
    fun onSuccess(message: String = "")
    fun onFailure(message: String)
}
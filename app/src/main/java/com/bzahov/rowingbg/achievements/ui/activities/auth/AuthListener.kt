package com.bzahov.rowingbg.achievements.ui.activities.auth

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}
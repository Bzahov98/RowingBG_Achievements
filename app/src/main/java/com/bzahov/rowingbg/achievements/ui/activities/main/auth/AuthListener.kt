package com.bzahov.rowingbg.achievements.ui.activities.main.auth

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}
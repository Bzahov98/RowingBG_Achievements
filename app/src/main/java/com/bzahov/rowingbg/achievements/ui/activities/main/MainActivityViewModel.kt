package com.bzahov.rowingbg.achievements.ui.activities.main

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.bzahov.rowingbg.achievements.data.repositories.UserAuthRepository

class MainActivityViewModel(
     private val repository: UserAuthRepository
) : ViewModel() {

    val user by lazy {
        repository.currentUser()
    }

    fun logout(context: Context) {
        Log.e("ss","ss")
        repository.logout()
//        context.startLoginActivity()
    }
}
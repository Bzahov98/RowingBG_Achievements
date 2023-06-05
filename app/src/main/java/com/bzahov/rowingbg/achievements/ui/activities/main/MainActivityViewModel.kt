package com.bzahov.rowingbg.achievements.ui.activities.main

import android.view.View
import androidx.lifecycle.ViewModel
import com.bzahov.rowingbg.achievements.data.repositories.UserAuthRepository

class MainActivityViewModel(
     private val repository: UserAuthRepository
) : ViewModel() {

    val user by lazy {
        repository.currentUser()
    }

    fun logout(view: View) {
        repository.logout()
//        view.context.startLoginActivity()
    }
}
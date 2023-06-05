package com.bzahov.rowingbg.achievements.ui.activities.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bzahov.rowingbg.achievements.data.repositories.UserAuthRepository

@Suppress("UNCHECKED_CAST")
class MainActivityViewModelFactory(
    private val repository: UserAuthRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }

}
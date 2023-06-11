package com.bzahov.rowingbg.achievements.ui.fragments.profile

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bzahov.rowingbg.achievements.R
import com.bzahov.rowingbg.achievements.RowingBGApplication.Companion.getAppString

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Profile Fragment"
    }

    private val _userFirstName = MutableLiveData<String>().apply {
        value = "Bozhidar"
    }
    private val _userLastName = MutableLiveData<String>().apply {
        value = "Zahov"
    }

    private val _email = MutableLiveData<String>().apply {
        value = getAppString(R.string.auth_hint_email)
    }

    val text: LiveData<String> = _text
    val firstName: LiveData<String> = _userFirstName
    val lastName: LiveData<String> = _userLastName
    val email: LiveData<String> = _email

    fun onClick(v : View){
        Log.e("Profile", (v.id == R.id.goToProfile).toString())
    }

    fun logOut() {
        Log.e("Profile", "LogOut")
    }
}
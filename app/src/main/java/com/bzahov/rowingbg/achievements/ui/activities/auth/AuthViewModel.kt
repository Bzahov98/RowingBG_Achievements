package com.bzahov.rowingbg.achievements.ui.activities.auth

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bzahov.rowingbg.achievements.data.model.User
import com.bzahov.rowingbg.achievements.data.model.UserData
import com.bzahov.rowingbg.achievements.data.model.UserRoleEnum
import com.bzahov.rowingbg.achievements.data.repositories.UserAuthRepository
import com.bzahov.rowingbg.achievements.utils.IntentUtils.Companion.startLoginActivityNoAnim
import com.bzahov.rowingbg.achievements.utils.IntentUtils.Companion.startSignUpActivityNoAnim
import com.bzahov.rowingbg.achievements.utils.InternetBrowserUtils.Companion.openNewTabWindow
import com.bzahov.rowingbg.achievements.utils.ValidationUtils.Companion.isValidLoginData
import com.bzahov.rowingbg.achievements.utils.ValidationUtils.Companion.isValidRegisterData
import io.reactivex.disposables.CompositeDisposable

class AuthViewModel(
    private val repository: UserAuthRepository
) : ViewModel() {

    private val userEmail = MutableLiveData("")

    private val userPass = MutableLiveData("")

    //email and password for the input
    var email: String? = null
    var password: String? = null
    var username: String? = null

    //auth listener
    var authListener: AuthListener? = null


    //disposable to dispose the Completable
    private val disposables = CompositeDisposable()

    val user by lazy {
        repository.currentUser()
    }

    //function to perform login
    fun login() {

        trimSpaces()
        //validating email and password
        if (!isValidLoginData(email, password)) {
            authListener?.onFailure("Invalid email or password")
            return
        }

        //authentication started
        authListener?.onStarted()

        //calling login from repository to perform the actual authentication
        val disposable = repository.login(email!!, password!!, authListener)

        disposables.add(disposable)
    }


    //Doing same thing with signup
    fun signup() {
        if (!isValidRegisterData(email, password, username)) {
            authListener?.onFailure("Please input all values correctly")
            return
        }
        authListener?.onStarted()
        val disposable = repository.register(
            User(
                null, name = null, email, username,
                UserData(),
                UserRoleEnum.ADMIN
            ),
            password!!,
            authListener
        )

        disposables.add(disposable)
    }

    fun onForgotPassword() {
        // TODO showDialog onForgotPassword
    }

    fun goToLogin(view: View) {
        view.context.startLoginActivityNoAnim()
    }

    fun goToSignup(view: View) {
        view.context.startSignUpActivityNoAnim()
    }

    private fun trimSpaces() {
        email = email?.trim()
        username = username?.trim()
    }

    //disposing the disposables
    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    fun openRowingBgSite(v: View) {
        v.context.openNewTabWindow("http://rowingbulgaria.com")
    }

    fun isLoggedIn(): Boolean =
        repository.currentUser() != null


}
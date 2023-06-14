package com.bzahov.rowingbg.achievements.data.repositories

import com.bzahov.rowingbg.achievements.data.firebase.FirebaseAuthDataSource
import com.bzahov.rowingbg.achievements.data.firebase.FirebaseCloudDataSource
import com.bzahov.rowingbg.achievements.data.firebase.FirebaseDatabaseDataSource
import com.bzahov.rowingbg.achievements.data.model.User
import com.bzahov.rowingbg.achievements.ui.activities.auth.AuthListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class UserAuthRepository constructor(
    private val firebaseAuth: FirebaseAuthDataSource,
    private val firebaseDatabase: FirebaseDatabaseDataSource,
    private val firebaseCloudDataSource: FirebaseCloudDataSource
) {
    private val disposables = CompositeDisposable()

    fun login(email: String, password: String, authListener: AuthListener?): Disposable {
        return firebaseAuth.login(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                //sending a success callback
                authListener?.onSuccess("Welcome $email")
            }, {
                //sending a failure callback
                authListener?.onFailure(it.message!!)
            })
    }

    fun register(user: User, password: String, authListener: AuthListener?): Disposable {
        return firebaseAuth.register(user.email ?: "", password).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    val currentUser = firebaseAuth.currentUser()
                    if (currentUser != null) {
                        firebaseDatabase.writeNewUserWithData(
                            user
                        )
                        val l = login(user.email ?: "", password, authListener)
                        disposables.add(l);
                    } else authListener?.onFailure("current user is null")
                },
                {
                    authListener?.onFailure(it.message!!)
                },
            )
    }

    fun register(email: String, password: String, authListener: AuthListener?): Disposable {
        return firebaseAuth.register(email, password).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    val currentUser = firebaseAuth.currentUser()
                    if (currentUser != null) {
                        firebaseDatabase.writeNewUser(
                            currentUser.uid,
                            currentUser.email,
                        )
                        authListener?.onSuccess("Welcome ${currentUser.email}")

                    } else authListener?.onFailure("current user is null")

                },
                {
                    authListener?.onFailure(it.message!!)
                },
            )
    }

    fun currentUser() = firebaseAuth.currentUser()

    fun logout() {
        firebaseAuth.logout()
//        firebaseAuth.currentUser()
    }
}
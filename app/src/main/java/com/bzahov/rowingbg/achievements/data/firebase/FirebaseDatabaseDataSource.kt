package com.bzahov.rowingbg.achievements.data.firebase

import com.bzahov.rowingbg.achievements.data.model.User
import com.google.firebase.database.FirebaseDatabase

class FirebaseDatabaseDataSource {
    private val firebaseDatabase: FirebaseDatabase by lazy {
        FirebaseDatabase.getInstance()
    }
    val reference
        get() = firebaseDatabase.reference.database.reference

    //old
    fun writeNewUser(userId: String, email: String?, name: String = "") {
        val user = User(userId, name, email, null,)
        reference.child("users").apply {
            child(userId).setValue(user)
        }
    }

    fun writeNewUserWithData(user: User) {
        reference.child("users").apply {
            user.uid?.let {
                child(it).setValue(user)
            }
        }
    }
}
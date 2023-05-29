package com.bzahov.rowingbg.achievements.data.firebase

import com.bzahov.rowingbg.achievements.data.model.User
import com.google.firebase.database.FirebaseDatabase

class FirebaseDatabaseDataSource {
    private val firebaseDatabase: FirebaseDatabase by lazy {
        FirebaseDatabase.getInstance()
    }
    val reference
        get() = firebaseDatabase.reference

    fun writeNewUser(userId: String, email: String?, name: String = "") {
        val user = User(userId, name, email)
        reference.child("users").child(userId).setValue(user)
    }
}
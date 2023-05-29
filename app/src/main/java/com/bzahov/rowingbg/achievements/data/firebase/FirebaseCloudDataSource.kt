package com.bzahov.rowingbg.achievements.data.firebase

import com.google.firebase.storage.FirebaseStorage

class FirebaseCloudDataSource {

    private val firebaseCloud: FirebaseStorage by lazy {
        FirebaseStorage.getInstance()
    }
}
package com.bzahov.rowingbg.achievements.data.model

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class User(
    var uid: String?,
    var name: String?,
    var email: String?,
    var username: String?,
    var userData: UserData? = null,
    var userRole: UserRoleEnum? = null,
) {


    @Exclude
    var isAuthenticated = false

    @Exclude
    var isNew = false

    @Exclude
    var isCreated = false

    constructor() : this("", "", "", "",null,null)
//    internal constructor(uid: String?, name: String?, email: String?, username: String?) {
//        this.uid = uid
//        this.name = name
//        this.email = email
//        this.username = username
//    }
}
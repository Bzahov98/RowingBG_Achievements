package com.bzahov.rowingbg.achievements.utils

import android.util.Patterns

class ValidationUtils {
    companion object {
        private const val usernameRegex = "^[A-Za-z][A-Za-z0-9_]{4,19}$"
        fun isValidLoginData(email: String?, password: String?) =
            email.isValidEmail() && password.isValidPassword()

        fun isValidRegisterData(email: String?, password: String?, username: String?) =
            email.isValidEmail() && password.isValidPassword() && username.isValidUsername()


        @JvmStatic
        fun String?.isValidEmail(): Boolean {
            return !this.isNullOrBlank() &&
                    Patterns.EMAIL_ADDRESS.matcher(this.trim()).matches()
        }

        @JvmStatic
        fun String?.isValidPassword(): Boolean {
            return !this.isNullOrBlank() && this.checkPassForSymbols()
        }

        // A valid username should start with an alphabet so, [A-Za-z].
        // All other characters can be alphabets, numbers or an underscore so, [A-Za-z0-9_].
        // length 4-20
        fun String?.isValidUsername(): Boolean {
            return this?.run {
                trim().matches(Regex(usernameRegex))
            } ?: false
        }

        fun String?.checkPassForSymbols(): Boolean {
            if (this.isNullOrBlank()) return false
            return this.length > 5
        }
    }
}
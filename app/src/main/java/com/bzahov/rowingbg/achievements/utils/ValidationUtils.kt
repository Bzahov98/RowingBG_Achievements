package com.bzahov.rowingbg.achievements.utils

import android.util.Patterns

class ValidationUtils {
    companion object {

        fun isValidLoginData(email: String?, password: String?) =
            email.isValidEmail() && password.isValidPassword()


        @JvmStatic
        fun String?.isValidEmail(): Boolean {
            return !this.isNullOrBlank() &&
                    Patterns.EMAIL_ADDRESS.matcher(this).matches()
        }

        @JvmStatic
        fun String?.isValidPassword(): Boolean {
            return !this.isNullOrBlank() && this.checkPassForSymbols()
        }

        fun String?.checkPassForSymbols(): Boolean {
            if (this.isNullOrBlank()) return false
            return this.length > 5
        }
    }
}


package com.bzahov.rowingbg.achievements.utils

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.bzahov.rowingbg.achievements.ui.activities.auth.LoginActivity
import com.bzahov.rowingbg.achievements.ui.activities.auth.SignUpActivity
import com.bzahov.rowingbg.achievements.ui.activities.main.MainActivity

class IntentUtils {
    companion object {
            fun Context.startMainActivity() {
            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_NO_HISTORY
                ContextCompat.startActivity(this, it, it.extras)
                //finish()
            }
        }

        fun Context.startLoginActivity(emailHint: String = "") {
            Intent(this, LoginActivity::class.java).also {
                val a = it.putExtra("email", emailHint)
                //it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                ContextCompat.startActivity(this, it, a.extras)
                //finish()
            }
        }

        fun Context.startHomeActivity() =
            Intent(this, MainActivity::class.java).also {
                //it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }

        fun Context.startLoginActivity() =
            Intent(this, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        fun Context.startLoginActivityNoAnim() =
            Intent(this, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(it)
            }
        fun Context.startSignUpActivity() =
            Intent(this, SignUpActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
       fun Context.startSignUpActivityNoAnim() =
            Intent(this, SignUpActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(it)
            }

        fun Context.startSignUpActivityNoAnimA() =
            Intent(this, SignUpActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(it)
            }
    }
}
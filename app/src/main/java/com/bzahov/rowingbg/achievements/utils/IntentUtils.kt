package com.bzahov.rowingbg.achievements.utils

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.bzahov.rowingbg.achievements.ui.activities.auth.LoginActivity
import com.bzahov.rowingbg.achievements.ui.activities.main.MainActivity

class IntentUtils {
    companion object {
        fun Context.startMainActivity() {
            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
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
    }
}
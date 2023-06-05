package com.bzahov.rowingbg.achievements.utils

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.bzahov.rowingbg.achievements.ui.activities.auth.LoginActivity
import com.bzahov.rowingbg.achievements.ui.activities.main.MainActivity

class IntentUtils {
    companion object {
        fun startMainActivity(context: Context) {
            Intent(context, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                ContextCompat.startActivity(context, it, it.extras)
                //finish()
            }
        }

        fun startLoginActivity(context: Context, emailHint: String = "") {
            Intent(context, LoginActivity::class.java).also {
                val a = it.putExtra("email", emailHint)
                //it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                ContextCompat.startActivity(context, it, a.extras)
                //finish()
            }
        }
    }
}
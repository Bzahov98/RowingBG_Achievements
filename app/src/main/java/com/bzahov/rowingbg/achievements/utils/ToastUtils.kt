package com.bzahov.rowingbg.achievements.utils

import android.content.Context
import android.widget.Toast

class ToastUtils {
    companion object {
        fun Context.showToastWithMsg(message: String?) {
            if (!message.isNullOrBlank()) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
package com.bzahov.rowingbg.achievements.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle

class InternetBrowserUtils {
    companion object {

        fun Context.openNewTabWindow(urls: String) {
            val uris = Uri.parse(urls)
            val intents = Intent(Intent.ACTION_VIEW, uris)
            val b = Bundle()
            b.putBoolean(urls, true)
            intents.putExtras(b)
            this.startActivity(intents)
        }
    }
}


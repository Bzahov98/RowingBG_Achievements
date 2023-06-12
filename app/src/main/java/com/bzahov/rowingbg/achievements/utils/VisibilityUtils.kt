package com.bzahov.rowingbg.achievements.utils

import android.view.View
import android.widget.TextView

class VisibilityUtils {
    companion object {
        @JvmStatic
        fun View.show() {
            this.visibility = View.VISIBLE
        }

        @JvmStatic
        fun View.hide() {
            this.visibility = View.INVISIBLE
        }

        @JvmStatic
        fun View.disappear() {
            this.visibility = View.GONE
        }

        @JvmStatic
        fun TextView.setVisibilityAndText(
            isVisible: Boolean,
            textFieldStringID: Int
        ) {
            apply {
                if (isVisible) show() else disappear()
                text = this.context.getString(textFieldStringID)
            }
        }

    }
}
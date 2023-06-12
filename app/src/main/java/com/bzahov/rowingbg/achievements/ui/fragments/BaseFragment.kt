package com.bzahov.rowingbg.achievements.ui.fragments

import android.content.Context
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {

//                showAreYouSureDialog()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this, // LifecycleOwner
            callback
        )
    }

}
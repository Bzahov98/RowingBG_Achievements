package com.bzahov.rowingbg.achievements.ui.activities.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bzahov.rowingbg.achievements.databinding.ActivityLoginBinding
import com.bzahov.rowingbg.achievements.utils.IntentUtils
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by closestKodein()
    private val factory: AuthViewModelFactory by instance()
    private lateinit var binding: ActivityLoginBinding

    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, factory)[AuthViewModel::class.java]

        binding.viewModel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        binding.progressbar.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        binding.progressbar.visibility = View.GONE
        IntentUtils.startMainActivity(this)
    }

    override fun onFailure(message: String) {
        binding.progressbar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        viewModel.user?.let {
            IntentUtils.startMainActivity(this)
        }
    }
}
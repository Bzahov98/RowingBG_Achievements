package com.bzahov.rowingbg.achievements.ui.activities.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bzahov.rowingbg.achievements.databinding.ActivitySignUpBinding
import com.bzahov.rowingbg.achievements.ui.activities.main.MainActivity
import com.bzahov.rowingbg.achievements.utils.IntentUtils.Companion.startMainActivity
import com.bzahov.rowingbg.achievements.utils.ToastUtils.Companion.showToastWithMsg
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class SignUpActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by closestKodein()
    private val factory : AuthViewModelFactory by instance()
    private lateinit var binding: ActivitySignUpBinding

    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)

        authViewModel = ViewModelProvider(this, factory)[AuthViewModel::class.java]

        binding.viewModel = authViewModel

        authViewModel.authListener = this
    }

    override fun onStarted() {
        binding.progressbar.visibility = View.VISIBLE
        Intent(this, MainActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }

    override fun onSuccess(message: String) {
        binding.progressbar.visibility = View.GONE
        this.showToastWithMsg(message)
        navigateToMainActivity()
    }

    override fun onFailure(message: String) {
        binding.progressbar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToMainActivity() {
        if (authViewModel.isLoggedIn()) {
            this.startMainActivity()
            finish()
        }
    }
}
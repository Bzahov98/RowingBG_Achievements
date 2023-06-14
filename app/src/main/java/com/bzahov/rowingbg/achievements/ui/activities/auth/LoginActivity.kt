package com.bzahov.rowingbg.achievements.ui.activities.auth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.bzahov.rowingbg.achievements.R
import com.bzahov.rowingbg.achievements.databinding.ActivityLoginBinding
import com.bzahov.rowingbg.achievements.utils.IntentUtils.Companion.startMainActivity
import com.bzahov.rowingbg.achievements.utils.ToastUtils.Companion.showToastWithMsg
import com.bzahov.rowingbg.achievements.utils.ValidationUtils.Companion.isValidEmail
import com.bzahov.rowingbg.achievements.utils.VisibilityUtils.Companion.disappear
import com.bzahov.rowingbg.achievements.utils.VisibilityUtils.Companion.show
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by closestKodein()
    private val factory: AuthViewModelFactory by instance()

    private lateinit var binding: ActivityLoginBinding

    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        authViewModel = ViewModelProvider(this, factory)[AuthViewModel::class.java]
        binding.viewModel = authViewModel

        setUpViews()
    }

    private fun setUpViews() {
        authViewModel.authListener = this
        binding.apply {
            textEmailLayout.editText?.apply {
                doAfterTextChanged {
                    error =
                        if (!viewModel?.email.isValidEmail()) getString(R.string.error_invalid_email) else null
                }
            }
        }
    }

    override fun onStarted() {
        binding.progressbar.show()
    }

    override fun onSuccess(message: String) {
        binding.progressbar.disappear()
        this.showToastWithMsg(message)

        navigateToMainActivity()
    }

    override fun onFailure(message: String) {
        binding.progressbar.disappear()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        navigateToMainActivity()

    }

    override fun onRestart() {
        navigateToMainActivity()

        super.onRestart()
    }
    override fun onResume() {
        navigateToMainActivity()

        super.onResume()
    }

    private fun navigateToMainActivity() {
        if (authViewModel.isLoggedIn()) {

            this@LoginActivity.startMainActivity()
            finish()
        }
    }
}
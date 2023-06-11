package com.bzahov.rowingbg.achievements.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bzahov.rowingbg.achievements.R
import com.bzahov.rowingbg.achievements.databinding.FragmentProfileBinding
import com.bzahov.rowingbg.achievements.databinding.ProfileNavigationBinding
import com.bzahov.rowingbg.achievements.ui.fragments.BaseFragment

class ProfileFragment : BaseFragment(), View.OnClickListener {

    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.apply {
            viewModel = ViewModelProvider(this@ProfileFragment)[ProfileViewModel::class.java]
            setupViews()
            return binding.root
        }
    }

    private fun setupViews() {
        binding.apply {
            val textView: TextView = textDashboard

            goToProfile.setupNavViews(
                R.drawable.ic_person_20,
                getString(R.string.profileNavigationProfile)
            )
            goToSettings.setupNavViews(
                R.drawable.baseline_settings_24,
                getString(R.string.profileNavigationSettings)
            )
            goToAdminPanel.setupNavViews(
                R.drawable.admin_panel_24,
                getString(R.string.profileNavigationAdminPanel)
            )
            goToInviteFriends.setupNavViews(
                R.drawable.ic_invite_friends_24,
                getString(R.string.profileNavigationInviteFriends)
            )

            goToRateUs.setupNavViews(
                R.drawable.ic_rate_us_24,
                getString(R.string.profileNavigationRateUs)
            )

            goToAbout.setupNavViews(
                R.drawable.ic_person_20,
                getString(R.string.profileNavigationAbout)
            )

            logOutFab.setOnClickListener {
                Toast.makeText(requireContext(), "logOut", Toast.LENGTH_SHORT).show()
                viewModel?.logOut()
            }

            viewModel?.text?.observe(viewLifecycleOwner) {
                textView.text = it
            }
        }

    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.goToProfile -> {
                Toast.makeText(requireContext(), "goToProfile", Toast.LENGTH_SHORT).show()
            }

            R.id.goToSettings -> {
                Toast.makeText(requireContext(), "goToProfile", Toast.LENGTH_SHORT).show()
            }
            R.id.goToAdminPanel -> {
                Toast.makeText(requireContext(), "adminPanel", Toast.LENGTH_SHORT).show()
            }

            R.id.goToInviteFriends -> {
                Toast.makeText(requireContext(), "goToProfile", Toast.LENGTH_SHORT).show()
            }

            R.id.goToAbout -> {
                Toast.makeText(requireContext(), "goToProfile", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun ProfileNavigationBinding.setupNavViews(
        icPerson20: Int,
        s: String
    ) {
        view.apply {
            profileNavigationImage.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    icPerson20
                )
            )
            profileNavigationTitle.text = s
            profileNavigationView.setOnClickListener(this@ProfileFragment)
        }
    }
}
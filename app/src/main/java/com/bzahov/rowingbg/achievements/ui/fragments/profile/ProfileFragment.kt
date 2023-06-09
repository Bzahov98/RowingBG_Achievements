package com.bzahov.rowingbg.achievements.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bzahov.rowingbg.achievements.databinding.FragmentProfileBinding
import com.bzahov.rowingbg.achievements.ui.fragments.BaseFragment

class ProfileFragment : BaseFragment() {

    private lateinit var binding: FragmentProfileBinding

    //    private lateinit var viewModel: ProfileViewModel
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
            viewModel?.text?.observe(viewLifecycleOwner) {
                textView.text = it
            }
        }

    }
}
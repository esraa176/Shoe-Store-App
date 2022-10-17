package com.example.shoe_store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoe_store.databinding.FragmentWelcomeOnboardingBinding


class WelcomeOnboardingFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWelcomeOnboardingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome_onboarding, container, false)

        binding.welcomeButton.setOnClickListener { view: View ->
            view.findNavController().navigate(WelcomeOnboardingFragmentDirections.actionWelcomeOnboardingFragmentToInstructionsOnboardingFragment())
        }
        return binding.root
    }


}
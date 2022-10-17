package com.example.shoe_store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.example.shoe_store.databinding.FragmentLoginScreenBinding


class LoginScreenFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginScreenBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login_screen, container, false)

        binding.loginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(LoginScreenFragmentDirections.actionLoginScreenFragmentToWelcomeOnboardingFragment())
        }

        binding.signupButton.setOnClickListener { view: View ->
            view.findNavController().navigate(LoginScreenFragmentDirections.actionLoginScreenFragmentToWelcomeOnboardingFragment())
        }
        return binding.root
    }


}
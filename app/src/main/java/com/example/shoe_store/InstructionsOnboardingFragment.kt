package com.example.shoe_store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoe_store.databinding.FragmentInstructionsOnboardingBinding


class InstructionsOnboardingFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentInstructionsOnboardingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instructions_onboarding, container, false)

        binding.instructionsButton.setOnClickListener { view: View ->
            view.findNavController().navigate(InstructionsOnboardingFragmentDirections.actionInstructionsOnboardingFragmentToShoeListingFragment())
        }
        return binding.root
    }


}
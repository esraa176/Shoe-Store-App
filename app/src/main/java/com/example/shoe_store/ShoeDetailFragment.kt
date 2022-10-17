package com.example.shoe_store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.shoe_store.databinding.FragmentShoeDetailBinding


class ShoeDetailFragment : Fragment() {

    private val shoesViewModel: LiveDataViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shoesViewModel.new_shoe = ShoeData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_detail, container,false)

        binding.shoe = shoesViewModel.new_shoe

        binding.cancelButton.setOnClickListener {
            view?.findNavController()?.navigateUp()
        }

        binding.saveButton.setOnClickListener {
            shoesViewModel.newShoe()
            view?.findNavController()?.navigateUp()
        }

        return binding.root
    }
}
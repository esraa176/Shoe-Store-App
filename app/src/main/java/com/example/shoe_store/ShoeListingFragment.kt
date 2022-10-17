package com.example.shoe_store

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.shoe_store.databinding.FragmentShoeListingBinding
import com.example.shoe_store.databinding.NewViewBinding


class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding
    private val sharedViewModel: LiveDataViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel.onStart()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_listing, container, false
        )

        binding.lifecycleOwner = this
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        binding.floatingBar.setOnClickListener { view: View ->
            view.findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }

        sharedViewModel.shoesList.observe(viewLifecycleOwner, Observer { shoesList ->
            for (shoe in shoesList) {
                addShoeToLayout(container, shoe)
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        view?.findNavController()?.navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToLoginScreenFragment())
        return true
    }

    private fun addShoeToLayout(container: ViewGroup?, shoe: ShoeData) {
        val shoeBinding: NewViewBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.new_view, container, false)

        shoeBinding.shoe = shoe
        binding.shoeListLayout.addView(shoeBinding.root)
    }

    /*private fun addShoeToLayout(container: ViewGroup?, shoe: ShoeData) {
        val newShoeNameText = TextView(getActivity())
        newShoeNameText.text = shoe.ShoeName

        val newShoeCompanyText = TextView(getActivity())
        newShoeCompanyText.text = shoe.ShoeCompany

        val newShoeSizeText = TextView(getActivity())
        newShoeSizeText.text = shoe.ShoeSize.toString()

        val newShoeDescriptionText = TextView(getActivity())
        newShoeDescriptionText.text = shoe.ShoeDescription

        binding.shoeListLayout.addView(newShoeNameText)
        binding.shoeListLayout.addView(newShoeCompanyText)
        binding.shoeListLayout.addView(newShoeSizeText)
        binding.shoeListLayout.addView(newShoeDescriptionText)
    }*/
}

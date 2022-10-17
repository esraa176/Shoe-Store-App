package com.example.shoe_store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<MutableList<ShoeData>>()
    val shoesList: LiveData<MutableList<ShoeData>>
        get() = _shoesList

    fun onStart()
    {
        var shoe = ShoeData()
        shoe.ShoeName = "Louis Vuitton Air Force 1"
        shoe.ShoeCompany = "Nike"
        shoe.ShoeSize = 38
        shoe.ShoeDescription = "Virgil Abloh - White"
        _shoesList.value = mutableListOf(shoe)
    }

    var new_shoe = ShoeData()
    fun newShoe() {
            _shoesList.value?.add(new_shoe)
    }
}
package com.example.coffeeapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeapp.Model.ItemsModel
import com.example.coffeeapp.Repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    fun loadFiltered(id: Int): LiveData<MutableList<ItemsModel>> {
        return repository.loadFiltered(id)
    }
}
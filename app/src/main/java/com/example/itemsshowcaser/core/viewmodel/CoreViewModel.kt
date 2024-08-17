package com.example.itemsshowcaser.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itemsshowcaser.core.model.Product
import com.example.itemsshowcaser.core.model.repository.Repository
import kotlinx.coroutines.launch

class CoreViewModel(private val repository: Repository): ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    fun getProductsResponse() {
        viewModelScope.launch {
            val productsList = repository.getProducts()
            _products.postValue(productsList)
            repository.setDataLocally(productsList)
        }
    }
}
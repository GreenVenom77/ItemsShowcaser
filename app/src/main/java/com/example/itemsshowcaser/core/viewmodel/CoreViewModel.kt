package com.example.itemsshowcaser.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itemsshowcaser.core.model.ProductsResponse
import com.example.itemsshowcaser.core.model.repository.Repository
import kotlinx.coroutines.launch

class CoreViewModel(private val repository: Repository): ViewModel() {
    private val _productsResponse = MutableLiveData<ProductsResponse>()
    val productsResponse: LiveData<ProductsResponse> get() = _productsResponse

    fun getProductsResponse() {
        viewModelScope.launch {
            _productsResponse.postValue(repository.getProducts())
        }
    }
}
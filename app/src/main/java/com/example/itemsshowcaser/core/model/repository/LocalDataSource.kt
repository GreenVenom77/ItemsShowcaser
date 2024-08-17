package com.example.itemsshowcaser.core.model.repository

import com.example.itemsshowcaser.core.model.Product
import com.example.itemsshowcaser.core.model.ProductsResponse

interface LocalDataSource {
    suspend fun getDataFromLocal(): ProductsResponse
    suspend fun saveDataToLocal(products: List<Product>)
}
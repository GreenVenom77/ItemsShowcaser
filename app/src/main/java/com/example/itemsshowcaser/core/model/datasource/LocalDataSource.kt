package com.example.itemsshowcaser.core.model.datasource

import com.example.itemsshowcaser.core.model.Product

interface LocalDataSource {
    suspend fun getDataFromLocal(): List<Product>
    suspend fun saveDataToLocal(products: List<Product>)
}
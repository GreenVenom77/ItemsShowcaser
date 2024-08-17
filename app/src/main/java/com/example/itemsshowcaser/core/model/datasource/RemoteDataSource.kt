package com.example.itemsshowcaser.core.model.datasource

import com.example.itemsshowcaser.core.model.Product

interface RemoteDataSource {
    suspend fun getDataFromRemote(): List<Product>
}
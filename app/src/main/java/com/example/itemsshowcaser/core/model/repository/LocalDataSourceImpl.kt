package com.example.itemsshowcaser.core.model.repository

import com.example.itemsshowcaser.core.model.Product
import com.example.itemsshowcaser.core.model.ProductsResponse

class LocalDataSourceImpl: LocalDataSource {
    override suspend fun getDataFromLocal(): ProductsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun saveDataToLocal(products: List<Product>) {
        TODO("Not yet implemented")
    }
}
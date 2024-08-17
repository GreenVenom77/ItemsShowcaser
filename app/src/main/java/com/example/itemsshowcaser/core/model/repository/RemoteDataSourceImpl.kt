package com.example.itemsshowcaser.core.model.repository

import com.example.itemsshowcaser.core.model.ProductsResponse
import com.example.itemsshowcaser.core.model.service.ProductsService

class RemoteDataSourceImpl(private val service: ProductsService): RemoteDataSource {
    override suspend fun getDataFromRemote(): ProductsResponse {
        return service.getProducts()
    }
}
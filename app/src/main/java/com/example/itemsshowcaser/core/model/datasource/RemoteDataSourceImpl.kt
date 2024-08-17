package com.example.itemsshowcaser.core.model.datasource

import com.example.itemsshowcaser.core.model.Product
import com.example.itemsshowcaser.core.model.service.ProductsService

class RemoteDataSourceImpl(private val service: ProductsService): RemoteDataSource {
    override suspend fun getDataFromRemote(): List<Product> {
        return service.getProducts().products
    }
}
package com.example.itemsshowcaser.core.model.repository

import com.example.itemsshowcaser.core.model.Product
import com.example.itemsshowcaser.core.model.ProductsResponse

class RepositoryImpl(private val remoteDataSource: RemoteDataSource): Repository {
    override suspend fun getProducts(): ProductsResponse {
        return remoteDataSource.getDataFromRemote()
    }

    override suspend fun setDataLocally(products: List<Product>) {
        TODO("Not yet implemented")
    }
}
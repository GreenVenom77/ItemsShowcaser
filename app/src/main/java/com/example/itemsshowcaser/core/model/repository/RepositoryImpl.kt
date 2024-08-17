package com.example.itemsshowcaser.core.model.repository

import com.example.itemsshowcaser.core.model.Product
import com.example.itemsshowcaser.core.model.datasource.LocalDataSource
import com.example.itemsshowcaser.core.model.datasource.RemoteDataSource

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): Repository {
    override suspend fun getProducts(): List<Product> {
        val remote = remoteDataSource.getDataFromRemote()
        val local = localDataSource.getDataFromLocal()

        return local.ifEmpty { remote }
    }

    override suspend fun setDataLocally(products: List<Product>) {
        localDataSource.saveDataToLocal(products)
    }
}
package com.example.itemsshowcaser.core.model.datasource

import com.example.itemsshowcaser.core.model.Product

class LocalDataSourceImpl(private val dao: ProductsDao): LocalDataSource {
    override suspend fun getDataFromLocal(): List<Product> {
        val products = dao.getAllProducts()
        return products
    }

    override suspend fun saveDataToLocal(products: List<Product>) {
        dao.addProducts(products)
    }
}
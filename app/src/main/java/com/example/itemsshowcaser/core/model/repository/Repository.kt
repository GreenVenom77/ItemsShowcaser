package com.example.itemsshowcaser.core.model.repository

import com.example.itemsshowcaser.core.model.Product
import com.example.itemsshowcaser.core.model.ProductsResponse

interface Repository {
    suspend fun getProducts(): ProductsResponse
    suspend fun setDataLocally(products: List<Product>)
}
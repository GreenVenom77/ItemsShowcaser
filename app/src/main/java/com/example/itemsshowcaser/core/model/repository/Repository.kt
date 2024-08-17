package com.example.itemsshowcaser.core.model.repository

import com.example.itemsshowcaser.core.model.Product

interface Repository {
    suspend fun getProducts(): List<Product>
    suspend fun setDataLocally(products: List<Product>)
}
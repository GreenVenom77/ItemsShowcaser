package com.example.itemsshowcaser.core.model.service

import com.example.itemsshowcaser.core.model.Product
import com.example.itemsshowcaser.core.model.ProductsResponse
import retrofit2.http.GET

interface ProductsService {
    @GET("products")
    suspend fun getProducts(): ProductsResponse
}
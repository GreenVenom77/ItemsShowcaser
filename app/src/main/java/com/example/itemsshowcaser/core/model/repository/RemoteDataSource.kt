package com.example.itemsshowcaser.core.model.repository

import com.example.itemsshowcaser.core.model.ProductsResponse

interface RemoteDataSource {
    suspend fun getDataFromRemote(): ProductsResponse
}
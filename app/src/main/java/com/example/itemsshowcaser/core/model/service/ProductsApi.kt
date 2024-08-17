package com.example.itemsshowcaser.core.model.service

import com.example.itemsshowcaser.core.model.service.RetrofitHelper.retrofit

object ProductsApi {
    val service: ProductsService by lazy { retrofit.create(ProductsService::class.java) }
}
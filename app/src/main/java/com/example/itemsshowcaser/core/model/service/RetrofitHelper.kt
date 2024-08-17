package com.example.itemsshowcaser.core.model.service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val gson: Gson = GsonBuilder().serializeNulls().create()
    private val gsonConverter: GsonConverterFactory = GsonConverterFactory.create(gson)
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(gsonConverter)
        .build()
}
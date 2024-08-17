package com.example.itemsshowcaser.itemdetails.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ReviewListConverter {
    @TypeConverter
    fun fromReviewList(list: List<Review>?): String? {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toReviewList(data: String?): List<Review>? {
        val listType = object : TypeToken<List<Review>>() {}.type
        return Gson().fromJson(data, listType)
    }
}
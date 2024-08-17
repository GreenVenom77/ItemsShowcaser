package com.example.itemsshowcaser.itemdetails.model

import androidx.room.TypeConverter

object StringListConverter {
    @TypeConverter
    fun fromStringList(list: List<String>?): String? {
        return list?.joinToString(separator = ",")
    }

    @TypeConverter
    fun toStringList(data: String?): List<String>? {
        return data?.split(",")?.map { it.trim() }
    }
}
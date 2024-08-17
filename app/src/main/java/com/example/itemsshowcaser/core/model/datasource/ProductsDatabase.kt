package com.example.itemsshowcaser.core.model.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.itemsshowcaser.core.model.Product
import com.example.itemsshowcaser.itemdetails.model.ReviewListConverter
import com.example.itemsshowcaser.itemdetails.model.StringListConverter

@Database(entities = [Product::class], version = 1)
@TypeConverters(StringListConverter::class, ReviewListConverter::class)
abstract class ProductsDatabase: RoomDatabase() {
    abstract fun productsDao(): ProductsDao

    companion object {
        @Volatile
        private var INSTANCE: ProductsDatabase? = null
        fun getDatabaseInstance(context: Context): ProductsDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = ProductsDatabase::class.java,
                    name = "products_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
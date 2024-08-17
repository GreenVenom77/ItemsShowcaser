package com.example.itemsshowcaser.core.model.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.itemsshowcaser.core.model.Product

@Dao
interface ProductsDao {
    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<Product>)

    @Update
    suspend fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)
}
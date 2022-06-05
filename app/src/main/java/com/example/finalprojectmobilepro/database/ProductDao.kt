package com.example.finalprojectmobilepro.database

import androidx.room.*

@Dao
interface ProductDao {
    @Query("SELECT * FROM $TABLE_PRODUCTS")
    fun getProductsFromDatabase(): List<ProductEntity>

    @Query("SELECT * FROM $TABLE_PRODUCTS WHERE product_id = :prod")
    fun getProductByProd(prod: Int): ProductEntity

    @Delete
    fun delete(product: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(product: ProductEntity)

}
package com.example.finalprojectmobilepro.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_PRODUCTS)
data class ProductEntity(
    @ColumnInfo(name = "product_id") @PrimaryKey val prod: Int,
    @ColumnInfo(name = "product_name") val name: String,
    val product_price: Double,
    val product_description: String,
    val product_stars: Double
)

fun ProductEntity.toProduct() = Product(
    prod,
    name,
    product_price,
    product_description,
    product_stars
)
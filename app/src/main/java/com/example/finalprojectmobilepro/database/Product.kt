package com.example.finalprojectmobilepro.database

class Product(
    product_id: Int,
    product_name: String,
    product_price: Double,
    product_description: String,
    product_stars: Double
) {
    val product_id: Int = product_id
    val product_name: String =product_name
    val product_price: Double = product_price
    val product_description: String = product_description
    val product_stars: Double = product_stars
}

fun Product.toEntity() = ProductEntity(
    product_id,
    product_name,
    product_price,
    product_description,
    product_stars
)
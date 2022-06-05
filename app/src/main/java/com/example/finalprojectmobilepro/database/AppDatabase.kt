package com.example.finalprojectmobilepro.database

import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 1
const val TABLE_PRODUCTS = "products"
const val DATABASE_NAME = "appdatabase.sqlite"

@Database(entities = [ProductEntity::class],
    version = DATABASE_VERSION
    )

abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}
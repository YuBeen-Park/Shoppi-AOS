package com.android.shoppi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.shoppi.presentation.main.CartItem

@Database(entities = [CartItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartItemDao(): CartItemDao
}
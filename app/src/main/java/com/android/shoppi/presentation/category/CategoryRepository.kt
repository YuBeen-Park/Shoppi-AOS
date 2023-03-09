package com.android.shoppi.presentation.category

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository(private val remoteDataSource: CategoryRemoteDataSource) {
    suspend fun getCategories(): List<Category> {
        return remoteDataSource.getCategories()
    }
}
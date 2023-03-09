package com.android.shoppi.presentation.category

import com.android.shoppi.network.ApiClient

class CategoryRemoteDataSource(private val apiClient:ApiClient) : CategoryDataSource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}
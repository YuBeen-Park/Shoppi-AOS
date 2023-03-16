package com.android.shoppi.repository

import com.android.shoppi.network.ApiClient
import com.android.shoppi.network.CategoryDetail

class CategoryDetailRemoteDataSource(private val api: ApiClient) : CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }
}
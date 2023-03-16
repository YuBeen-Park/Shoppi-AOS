package com.android.shoppi.repository

import com.android.shoppi.network.CategoryDetail

interface CategoryDetailDataSource {
    suspend fun getCategoryDetail(): CategoryDetail
}
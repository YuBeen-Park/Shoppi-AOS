package com.android.shoppi.presentation.category

interface CategoryDataSource {

    suspend fun getCategories():List<Category>
}
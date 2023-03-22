package com.android.shoppi.repository

import com.android.shoppi.presentation.main.Product

class ProductDetailRepository(
    private val remoteDataSource: ProductDetailDataSource
) {
    suspend fun getProductDetail(productId: String): Product {
        return remoteDataSource.getProductDetail(productId)
    }
}
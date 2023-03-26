package com.android.shoppi.repository

import com.android.shoppi.presentation.main.Product

interface ProductDetailDataSource {
    suspend fun getProductDetail(productId: String): Product
}
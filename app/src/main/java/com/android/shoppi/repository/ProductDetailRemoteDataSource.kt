package com.android.shoppi.repository

import com.android.shoppi.network.ApiClient
import com.android.shoppi.presentation.main.Product

class ProductDetailRemoteDataSource(
    private val api: ApiClient
) : ProductDetailDataSource {
    override suspend fun getProductDetail(productId: String): Product {
        return api.getProductDetail(productId)
    }
}
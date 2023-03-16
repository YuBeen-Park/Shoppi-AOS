package com.android.shoppi.network

import com.android.shoppi.presentation.category.Category
import com.android.shoppi.presentation.main.Product
import com.android.shoppi.presentation.main.Title
import com.google.gson.annotations.SerializedName

data class CategoryDetail (
    @SerializedName("top_selling")
    val topSelling: TopSelling,
    val promotions: Promotion,
)

data class TopSelling(
    val title: Title,
    val categories: List<Category>
)

data class Promotion(
    val title: Title,
    val items: List<Product>
)
package com.android.shoppi.presentation.main

import com.google.gson.annotations.SerializedName

data class HomeData(
    val title: Title,
    @SerializedName("top_banners")
    val topBanners: List<Banner>,
    val promotions: Promotions,
)

data class Promotions(
    val title: Title,
    @SerializedName("items")
    val products: List<Product>,
)

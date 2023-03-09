package com.android.shoppi.presentation.category

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("category_id")
    val categoryId: String,
    val label: String,
    @SerializedName("thumbnail_image_url")
    val thumbnailImageUrl: String,
    @SerializedName("updated")
    val updated: Boolean,

    )

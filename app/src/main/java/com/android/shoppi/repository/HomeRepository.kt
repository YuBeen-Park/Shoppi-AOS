package com.android.shoppi.repository

import com.android.shoppi.presentation.main.HomeData

class HomeRepository(
    private val assetDataSource: HomeDataSource
) {
    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}
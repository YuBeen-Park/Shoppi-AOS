package com.android.shoppi.repository

import com.android.shoppi.presentation.main.HomeData

interface HomeDataSource {
    fun getHomeData(): HomeData?
}

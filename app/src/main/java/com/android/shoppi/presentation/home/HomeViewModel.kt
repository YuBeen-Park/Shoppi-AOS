package com.android.shoppi.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.shoppi.presentation.main.Banner
import com.android.shoppi.presentation.main.Product
import com.android.shoppi.presentation.main.Title
import com.android.shoppi.repository.HomeRepository

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {
    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> get() = _title
    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> get() = _topBanners
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    init {
        fetchHomeData()
    }

    private fun fetchHomeData() {
        val homeData = homeRepository.getHomeData()
        homeData?.let { data ->
            _title.value = data.title
            _topBanners.value = data.topBanners
            _products.value = data.promotions.products
        }
    }
}

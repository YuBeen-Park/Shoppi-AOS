package com.android.shoppi.presentation.categoryDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shoppi.network.Promotion
import com.android.shoppi.network.TopSelling
import com.android.shoppi.repository.CategoryDetailRepository
import kotlinx.coroutines.launch

class CategoryDetailViewModel(private val categoryDetailRepository: CategoryDetailRepository) :
    ViewModel() {

    private val _topSelling = MutableLiveData<TopSelling>()
    val topSelling: LiveData<TopSelling> get() = _topSelling
    private val _promotions = MutableLiveData<Promotion>()
    val promotions: LiveData<Promotion> get() = _promotions

    init {
        getCategoryDetail()
    }

    private fun getCategoryDetail() {
        viewModelScope.launch {
            val categoryDetailData = categoryDetailRepository.getCategoryDetail()
            _topSelling.value = categoryDetailData.topSelling
            _promotions.value = categoryDetailData.promotions
        }
    }
}
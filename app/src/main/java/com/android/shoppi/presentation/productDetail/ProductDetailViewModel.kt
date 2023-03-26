package com.android.shoppi.presentation.productDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shoppi.presentation.main.Product
import com.android.shoppi.repository.ProductDetailRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class ProductDetailViewModel(
    private val productDetailRepository: ProductDetailRepository
) : ViewModel() {
    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> get() = _product

    fun fetchProductDetail(productId: String) {
        viewModelScope.launch {
            _product.value = productDetailRepository.getProductDetail(productId)
            Timber.d("$_product")
        }
    }
}
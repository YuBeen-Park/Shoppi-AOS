package com.android.shoppi.presentation.productDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shoppi.presentation.main.Product
import com.android.shoppi.repository.CartRepository
import com.android.shoppi.repository.ProductDetailRepository
import com.android.shoppi.util.Event
import kotlinx.coroutines.launch
import timber.log.Timber

class ProductDetailViewModel(
    private val productDetailRepository: ProductDetailRepository,
    private val cartRepository: CartRepository,
) : ViewModel() {
    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> get() = _product

    private val _addCartEvent = MutableLiveData<Event<Unit>>()
    val addCartEvent : LiveData<Event<Unit>> get() = _addCartEvent


    fun fetchProductDetail(productId: String) {
        viewModelScope.launch {
            _product.value = productDetailRepository.getProductDetail(productId)
            Timber.d("$_product")
        }
    }

    fun addCart(product: Product){
        viewModelScope.launch {
            cartRepository.addCartItem(product)
            _addCartEvent.value = Event(Unit)
        }
    }
}
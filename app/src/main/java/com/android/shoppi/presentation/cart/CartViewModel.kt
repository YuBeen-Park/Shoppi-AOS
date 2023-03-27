package com.android.shoppi.presentation.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shoppi.presentation.main.CartItem
import com.android.shoppi.repository.CartRepository
import kotlinx.coroutines.launch

class CartViewModel(
    private val cartRepository: CartRepository,
) : ViewModel() {
    private val _items = MutableLiveData<List<CartItem>>()
    val items: LiveData<List<CartItem>> get() = _items

    init {
        fetchCartItem()
    }

    private fun fetchCartItem() {
        viewModelScope.launch {
            _items.value = cartRepository.getCartItems()
        }
    }
}
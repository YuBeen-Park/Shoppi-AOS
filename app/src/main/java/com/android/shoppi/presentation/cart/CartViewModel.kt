package com.android.shoppi.presentation.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.shoppi.presentation.main.CartItem

class CartViewModel : ViewModel() {
    private val _items = MutableLiveData<List<CartItem>>()
    val items: LiveData<List<CartItem>> get() = _items

    fun fetchCartItem(){
        _items.value
    }
}
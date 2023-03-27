package com.android.shoppi.repository

import com.android.shoppi.presentation.main.CartItem

interface CartItemDataSource {
    suspend fun getCartItems(): List<CartItem>

    suspend fun addCartItem(cartItem: CartItem)
}
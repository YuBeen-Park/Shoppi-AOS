package com.android.shoppi.repository

import com.android.shoppi.database.CartItemDao
import com.android.shoppi.presentation.main.CartItem

class CartItemLocalDataSource(
    private val dao: CartItemDao
) : CartItemDataSource {
    override suspend fun getCartItems(): List<CartItem> {
        return dao.load()
    }

    override suspend fun addCartItem(cartItem: CartItem) {
        dao.insert(cartItem)
    }

}
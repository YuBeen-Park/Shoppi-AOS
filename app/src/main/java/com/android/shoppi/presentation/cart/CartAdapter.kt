package com.android.shoppi.presentation.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.shoppi.databinding.ItemCartBinding
import com.android.shoppi.databinding.ItemCartSectionBinding
import com.android.shoppi.presentation.main.CartHeader
import com.android.shoppi.presentation.main.CartItem
import com.android.shoppi.presentation.main.CartProduct

private const val VIEW_TYPE_HEADER = 0
private const val VIEW_TYPE_ITEM = 1

class CartAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val cartProducts = mutableListOf<CartProduct>()

    class HeaderViewHolder(private val binding: ItemCartSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(header: CartHeader) {
            binding.header = header
            binding.executePendingBindings()
        }
    }

    class ItemViewHolder(private val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CartItem) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_HEADER -> HeaderViewHolder(
                ItemCartSectionBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            else -> ItemViewHolder(ItemCartBinding.inflate(inflater, parent, false))
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> {
                val item = cartProducts[position] as CartHeader
                holder.bind(item)
            }
            is ItemViewHolder -> {
                val item = cartProducts[position] as CartItem
                holder.bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (cartProducts[position]) {
            is CartHeader -> VIEW_TYPE_HEADER
            is CartItem -> VIEW_TYPE_ITEM
        }
    }

    override fun getItemCount(): Int {
        return cartProducts.size
    }

    fun submitHeaderAndItemList(items: List<CartItem>) {
        val itemGroups =
            items.groupBy { it.brandName } //키로 사용할 값을 전달하면 키에 해당하는 value를 추가해준 데이터를 반환해줌
        val products = mutableListOf<CartProduct>()
        itemGroups.entries.forEach { entry ->
            //entry.key // brandName (키)
            val header = CartHeader(entry.key)
            products.add(header)
            products.addAll(entry.value)
        }
        cartProducts.addAll(products)
        notifyItemRangeInserted(cartProducts.size, products.size)
    }
}
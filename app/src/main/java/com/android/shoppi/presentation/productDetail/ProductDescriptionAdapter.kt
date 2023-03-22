package com.android.shoppi.presentation.productDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.shoppi.databinding.ItemProductDetailBinding
import com.android.shoppi.presentation.main.Description

class ProductDescriptionAdapter :
    ListAdapter<Description, ProductDescriptionAdapter.ProductDescriptionViewHolder>(ProductDiffUtil()) {

    class ProductDescriptionViewHolder(private val binding: ItemProductDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(description: Description) {
            binding.imageUrl = description.imageUrl
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductDescriptionViewHolder {
        val binding =
            ItemProductDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductDescriptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductDescriptionViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}

class ProductDiffUtil : DiffUtil.ItemCallback<Description>() {
    override fun areContentsTheSame(oldItem: Description, newItem: Description): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: Description, newItem: Description): Boolean {
        return oldItem == newItem
    }
}
package com.android.shoppi.presentation.categoryDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.shoppi.databinding.ItemCategoryTopSellingBinding
import com.android.shoppi.presentation.category.Category
import com.android.shoppi.presentation.category.CategoryDiffCallback

class CategoryTopSellingItemAdapter :
    ListAdapter<Category, CategoryTopSellingItemAdapter.TopSellingViewHolder>(CategoryDiffCallback()) {
    class TopSellingViewHolder(private val binding: ItemCategoryTopSellingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.category = category
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopSellingViewHolder {
        val binding = ItemCategoryTopSellingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TopSellingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopSellingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
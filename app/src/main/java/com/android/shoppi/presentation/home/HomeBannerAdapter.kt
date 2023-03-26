package com.android.shoppi.presentation.home

import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.shoppi.databinding.ItemHomeBannerBinding
import com.android.shoppi.presentation.main.Banner

class HomeBannerAdapter(
    private val openProductDetail: (String) -> Unit,
) : ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(
    BannerDiffCallback()
) {
    class HomeBannerViewHolder(private val binding: ItemHomeBannerBinding, private val openProductDetail: (String) -> Unit,) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(banner: Banner) {
            binding.banner = banner
            binding.tvBannerBadge.background =
                ColorDrawable(Color.parseColor(banner.badge.backgroundColor))
            binding.tvBannerDetailProductPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.ivBannerImage.setOnClickListener {
                openProductDetail(banner.productDetail.productId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HomeBannerViewHolder(ItemHomeBannerBinding.inflate(inflater, parent, false), openProductDetail = openProductDetail)
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class BannerDiffCallback : DiffUtil.ItemCallback<Banner>() {
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }
}

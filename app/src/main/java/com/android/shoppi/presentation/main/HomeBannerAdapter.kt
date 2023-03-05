package com.android.shoppi.presentation.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.shoppi.databinding.ItemHomeBannerBinding
import com.android.shoppi.util.setImage
import java.text.DecimalFormat
import kotlin.math.roundToInt

class HomeBannerAdapter() : ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(
    BannerDiffCallback()
) {
    class HomeBannerViewHolder(private val binding: ItemHomeBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(banner: Banner) {
            binding.ivBannerImage.setImage(banner.backgroundImageUrl)
            binding.tvBannerBadge.text = banner.badge.label
            binding.tvBannerBadge.background =
                ColorDrawable(Color.parseColor(banner.badge.backgroundColor))
            binding.tvBannerTitle.text = banner.label
            binding.ivBannerDetailThumbnail.setImage(banner.productDetail.thumbnailImageUrl)
            binding.tvBannerDetailBrandLabel.text = banner.productDetail.brandName
            binding.tvBannerDetailProductLabel.text = banner.productDetail.label
            binding.tvBannerDetailProductDiscountRate.text = "${banner.productDetail.discountRate}%"
            binding.tvBannerDetailProductDiscountPrice.text = calculateDiscountAmount(
                banner.productDetail.discountRate,
                banner.productDetail.price
            )
            binding.tvBannerDetailProductPrice.text = applyPriceFormat(banner.productDetail.price)

        }

        private fun calculateDiscountAmount(discountRate: Int, price: Int): String {
            val discountRate = (((100 - discountRate) / 100.0)).roundToInt()
            return applyPriceFormat(discountRate * price)
        }

        private fun applyPriceFormat(price: Int): String {
            val decimalFormat = DecimalFormat("#,###")
            return decimalFormat.format(price) + "원"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HomeBannerViewHolder(ItemHomeBannerBinding.inflate(inflater, parent, false))
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
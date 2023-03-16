package com.android.shoppi.presentation.categoryDetail

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ConcatAdapter
import com.android.shoppi.R
import com.android.shoppi.databinding.FragmentCategoryDetailBinding
import com.android.shoppi.util.binding.BindingFragment

class CategoryDetailFragment :
    BindingFragment<FragmentCategoryDetailBinding>(R.layout.fragment_category_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        val categoryId = requireArguments().getString(KEY_CATEGORY_ID)
        initLayout()
    }

    private fun initLayout() {
        val categoryLabel = requireArguments().getString(KEY_CATEGORY_LABEL)
        binding.toolbarCategoryDetail.title = categoryLabel
        val titleAdapter = CategorySectionTitleAdapter()
        val promotionAdapter = CategoryPromotionAdapter()
        binding.rvCategoryDetail.adapter = ConcatAdapter(titleAdapter, promotionAdapter)
    }

    companion object {
        const val KEY_CATEGORY_ID = "category_id"
        const val KEY_CATEGORY_LABEL = "category_label"
    }
}
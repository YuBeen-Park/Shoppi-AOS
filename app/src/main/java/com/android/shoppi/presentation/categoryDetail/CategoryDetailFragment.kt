package com.android.shoppi.presentation.categoryDetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.android.shoppi.R
import com.android.shoppi.ViewModelFactory
import com.android.shoppi.databinding.FragmentCategoryDetailBinding
import com.android.shoppi.util.binding.BindingFragment
import timber.log.Timber

class CategoryDetailFragment :
    BindingFragment<FragmentCategoryDetailBinding>(R.layout.fragment_category_detail) {

    private val titleAdapter = CategorySectionTitleAdapter()
    private val promotionAdapter = CategoryPromotionAdapter()
    private val topSellingSectionAdapter = CategoryTopSellingSectionAdapter()
    private val viewModel: CategoryDetailViewModel by viewModels { ViewModelFactory(requireContext()) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        val categoryId = requireArguments().getString(KEY_CATEGORY_ID)
        initLayout()
        observeData()
    }

    private fun initLayout() {
        val categoryLabel = requireArguments().getString(KEY_CATEGORY_LABEL)
        binding.toolbarCategoryDetail.title = categoryLabel
        binding.rvCategoryDetail.adapter =
            ConcatAdapter(topSellingSectionAdapter, titleAdapter, promotionAdapter)
    }

    private fun observeData() {
        viewModel.topSelling.observe(viewLifecycleOwner) { topSelling ->
            topSellingSectionAdapter.submitList(listOf(topSelling))
        }
        viewModel.promotions.observe(viewLifecycleOwner) { promotions ->
            titleAdapter.submitList(listOf(promotions.title))
            promotionAdapter.submitList(promotions.items)
        }
    }

    companion object {
        const val KEY_CATEGORY_ID = "category_id"
        const val KEY_CATEGORY_LABEL = "category_label"
    }
}
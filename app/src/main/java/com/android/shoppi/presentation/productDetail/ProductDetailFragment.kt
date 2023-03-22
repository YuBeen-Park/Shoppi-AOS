package com.android.shoppi.presentation.productDetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.shoppi.R
import com.android.shoppi.ViewModelFactory
import com.android.shoppi.databinding.FragmentProductDetailBinding
import com.android.shoppi.presentation.home.HomeFragment.Companion.KEY_PRODUCT_ID
import com.android.shoppi.util.binding.BindingFragment
import timber.log.Timber

class ProductDetailFragment :
    BindingFragment<FragmentProductDetailBinding>(R.layout.fragment_product_detail) {

    private val viewModel: ProductDetailViewModel by viewModels { ViewModelFactory(requireContext()) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        binding.lifecycleOwner = viewLifecycleOwner
        setNavigation()
        requireArguments().getString(KEY_PRODUCT_ID)?.let { productId ->
            setLayout(productId)
        }
    }

    private fun setNavigation() {
        binding.toolbarProductDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setLayout(productId: String) {
        Timber.d("$productId")
        viewModel.fetchProductDetail(productId)
        val detailImageAdapter = ProductDescriptionAdapter()
        binding.rvProductDetail.adapter = detailImageAdapter
        viewModel.product.observe(viewLifecycleOwner) { product ->
            binding.product = product
            detailImageAdapter.submitList(product.descriptions)
        }
    }
}
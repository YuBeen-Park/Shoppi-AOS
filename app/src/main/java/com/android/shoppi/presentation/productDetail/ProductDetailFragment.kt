package com.android.shoppi.presentation.productDetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.shoppi.R
import com.android.shoppi.ViewModelFactory
import com.android.shoppi.databinding.FragmentProductDetailBinding
import com.android.shoppi.presentation.home.HomeFragment.Companion.KEY_PRODUCT_ID
import com.android.shoppi.util.EventObserver
import com.android.shoppi.util.binding.BindingFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import timber.log.Timber

class ProductDetailFragment :
    BindingFragment<FragmentProductDetailBinding>(R.layout.fragment_product_detail) {

    private val viewModel: ProductDetailViewModel by viewModels { ViewModelFactory(requireContext()) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
        observeData()
    }

    private fun initLayout() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        setNavigation()
        requireArguments().getString(KEY_PRODUCT_ID)?.let { productId ->
            setLayout(productId)
        }
    }

    private fun observeData() {
        viewModel.addCartEvent.observe(viewLifecycleOwner, EventObserver {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("장바구니에 상품이 담겼습니다.")
                .setPositiveButton(
                    "확인"
                ) { dialog, which -> }
                .show()
        })
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
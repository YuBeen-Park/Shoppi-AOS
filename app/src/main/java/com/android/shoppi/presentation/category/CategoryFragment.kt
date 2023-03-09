package com.android.shoppi.presentation.category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.android.shoppi.R
import com.android.shoppi.ViewModelFactory
import com.android.shoppi.databinding.FragmentCategoryBinding
import com.android.shoppi.util.binding.BindingFragment

class CategoryFragment : BindingFragment<FragmentCategoryBinding>(R.layout.fragment_category) {
    private val viewModel: CategoryViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()

    }
    fun initLayout(){
        val categoryAdapter = CategoryAdapter()
        binding.rvCategoryList.adapter = categoryAdapter
        viewModel.items.observe(viewLifecycleOwner){
            categoryAdapter.submitList(it)
        }
    }
}
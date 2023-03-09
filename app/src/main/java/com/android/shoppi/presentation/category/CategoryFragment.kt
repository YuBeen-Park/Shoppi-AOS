package com.android.shoppi.presentation.category

import android.os.Bundle
import android.util.Log
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
        viewModel.items.observe(viewLifecycleOwner){
            Log.d("Category", "items=$it")
        }
    }
}
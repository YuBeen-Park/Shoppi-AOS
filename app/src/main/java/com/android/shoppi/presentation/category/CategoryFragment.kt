package com.android.shoppi.presentation.category

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.shoppi.R
import com.android.shoppi.ViewModelFactory
import com.android.shoppi.databinding.FragmentCategoryBinding
import com.android.shoppi.util.EventObserver
import com.android.shoppi.util.binding.BindingFragment

class CategoryFragment : BindingFragment<FragmentCategoryBinding>(R.layout.fragment_category) {
    private val viewModel: CategoryViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
        observeData()
    }

    private fun initLayout() {
        val categoryAdapter = CategoryAdapter(viewModel)
        binding.rvCategoryList.adapter = categoryAdapter
        viewModel.items.observe(viewLifecycleOwner) {
            categoryAdapter.submitList(it)
        }
    }

    private fun observeData() {
//        viewModel.openCategoryEvent.observe(viewLifecycleOwner) { category ->
//            openCategoryDetail(category.categoryId, category.label)
//        }
        //위처럼 구현하면 디테일로 이동했을 때 백버튼이 동작을 안함
        //사실 돌아오자마자 아직 옵저브하는게 true라서 돌아오지 못하고 다시 이동하는 로직이 되어 버린다
        viewModel.openCategoryEvent.observe(viewLifecycleOwner, EventObserver{ category ->
            openCategoryDetail(category.categoryId, category.label)
        })
    }

    private fun openCategoryDetail(categoryId: String, categoryLabel: String) {
        findNavController().navigate(
            R.id.action_category_to_category_detail, bundleOf(
                KEY_CATEGORY_ID to categoryId,
                KEY_CATEGORY_LABEL to categoryLabel,
            )
        )
    }
    companion object{
        const val KEY_CATEGORY_ID= "category_id"
        const val KEY_CATEGORY_LABEL="category_label"
    }
}
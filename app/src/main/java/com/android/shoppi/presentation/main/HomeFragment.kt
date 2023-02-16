package com.android.shoppi.presentation.main

import android.os.Bundle
import android.view.View
import com.android.shoppi.R
import com.android.shoppi.databinding.FragmentHomeBinding
import com.android.shoppi.util.binding.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addListeners()
    }

    private fun addListeners() {
        binding.btnEnterProductDetail.setOnClickListener {
            //parentFragmentManager
            //childFragmentManager
            parentFragmentManager.beginTransaction() // fragment의 추가 삭제 교체 요청
                .add(R.id.container_main, ProductDetailFragment())
                .commit()
        }
    }
}
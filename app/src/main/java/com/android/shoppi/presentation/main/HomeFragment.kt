package com.android.shoppi.presentation.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
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
//            parentFragmentManager.beginTransaction() // fragment의 추가 삭제 교체 요청
//                .add(R.id.container_main, ProductDetailFragment())
//                .commit()
            // 위의 방식을 이용해서 구현했을 때 기존의 fragment가 뒤에 겹쳐서 보임
            // -> 위에 다른 fragment을 올리기 때문?
            findNavController().navigate(R.id.action_home_to_product_detail)
        }
    }
}
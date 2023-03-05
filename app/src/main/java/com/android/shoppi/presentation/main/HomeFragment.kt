package com.android.shoppi.presentation.main

import android.os.Bundle
import android.view.View
import com.android.shoppi.R
import com.android.shoppi.databinding.FragmentHomeBinding
import com.android.shoppi.util.AssetLoader
import com.android.shoppi.util.binding.BindingFragment
import com.android.shoppi.util.setImage
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addListeners()
        initLayout()
    }

    private fun initLayout() {
        val assetLoader = AssetLoader()
        val homeJsonString = assetLoader.getJsonString(requireContext(), "home.json")
        if (!homeJsonString.isNullOrEmpty()) {
            val gson = Gson()
            val homeData = gson.fromJson(homeJsonString, HomeData::class.java)

            binding.tvToolbarHomeTitle.text = homeData.title.text
            binding.ivToolbarHomeIcon.setImage(homeData.title.iconUrl)

            binding.vpHomeBanner.adapter = HomeBannerAdapter().apply {
                submitList(homeData.topBanners)
            }
            binding.vpHomeBanner.offscreenPageLimit = 3
            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
            val screenWidth = resources.displayMetrics.widthPixels
            val offset = screenWidth - pageWidth - pageMargin
            binding.vpHomeBanner.setPageTransformer { page, position ->
                page.translationX = position * -offset
            }
            TabLayoutMediator(
                binding.vpHomeBannerIndicator, binding.vpHomeBanner
            ) { tab, position ->

            }.attach()
        }
    }

    private fun addListeners() {
//        binding.btnEnterProductDetail.setOnClickListener {
//            //parentFragmentManager
//            //childFragmentManager
////            parentFragmentManager.beginTransaction() // fragment의 추가 삭제 교체 요청
////                .add(R.id.container_main, ProductDetailFragment())
////                .commit()
//            // 위의 방식을 이용해서 구현했을 때 기존의 fragment가 뒤에 겹쳐서 보임
//            // -> 위에 다른 fragment을 올리기 때문?
//            findNavController().navigate(R.id.action_home_to_product_detail)
//        }
    }
}
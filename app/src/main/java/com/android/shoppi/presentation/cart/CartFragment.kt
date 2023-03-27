package com.android.shoppi.presentation.cart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.android.shoppi.R
import com.android.shoppi.ViewModelFactory
import com.android.shoppi.databinding.FragmentCartBinding
import com.android.shoppi.util.binding.BindingFragment

class CartFragment : BindingFragment<FragmentCartBinding>(R.layout.fragment_cart) {

    private val viewModel: CartViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setListAdapter()
    }

    private fun setListAdapter() {
        val cartAdapter = CartAdapter()
        binding.rvCart.adapter = cartAdapter
        viewModel.items.observe(viewLifecycleOwner) { cartItems ->
            cartAdapter.submitHeaderAndItemList(cartItems)
        }
    }
}

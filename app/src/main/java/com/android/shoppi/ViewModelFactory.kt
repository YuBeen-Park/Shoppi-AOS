package com.android.shoppi

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.shoppi.network.ApiClient
import com.android.shoppi.presentation.cart.CartViewModel
import com.android.shoppi.presentation.category.CategoryRemoteDataSource
import com.android.shoppi.presentation.category.CategoryRepository
import com.android.shoppi.presentation.category.CategoryViewModel
import com.android.shoppi.presentation.categoryDetail.CategoryDetailViewModel
import com.android.shoppi.presentation.home.HomeViewModel
import com.android.shoppi.presentation.productDetail.ProductDetailViewModel
import com.android.shoppi.repository.*
import com.android.shoppi.util.AssetLoader

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                CategoryViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository =
                    CategoryDetailRepository(CategoryDetailRemoteDataSource(ApiClient.create()))
                CategoryDetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ProductDetailViewModel::class.java) -> {
                val repository =
                    ProductDetailRepository(ProductDetailRemoteDataSource(ServiceLocator.provideApiClient()))
                ProductDetailViewModel(
                    repository,
                    ServiceLocator.provideCartRepository(context)
                ) as T
            }
            modelClass.isAssignableFrom(CartViewModel::class.java) -> {
                CartViewModel(ServiceLocator.provideCartRepository(context)) as T
            }
            else -> {
                throw java.lang.IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}

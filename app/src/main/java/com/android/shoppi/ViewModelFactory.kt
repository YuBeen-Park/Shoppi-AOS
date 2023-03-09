package com.android.shoppi

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.shoppi.presentation.home.HomeViewModel
import com.android.shoppi.repository.HomeAssetDataSource
import com.android.shoppi.repository.HomeRepository
import com.android.shoppi.util.AssetLoader

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
            return HomeViewModel(repository) as T
        } else {
            throw java.lang.IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}

package com.android.shoppi.presentation.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    private val _items = MutableLiveData<List<Category>>()
    val items: LiveData<List<Category>> get() = _items

    init {
        loadCategory()
    }

    fun loadCategory() {
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            _items.value = categories
        }
    }
}
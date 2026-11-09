package com.bgramma.storeorder.ui.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bgramma.storeorder.model.CategoryModel
import com.bgramma.storeorder.network.RetrofitClient
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel(){

    private val _categories = MutableLiveData<List<CategoryModel>>()
    val categories : LiveData<List<CategoryModel>> = _categories

    fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.categoryApi.getCategories()

                if ( response.isSuccessful ) {
                    response.body()?.let { categories ->
                        _categories.value = categories
                    }
                }
            } catch ( e: Exception ) {
                Log.e("API_ERROR", "카테고리 수신 실패 : ${e.message}")
            }
        }
    }
}
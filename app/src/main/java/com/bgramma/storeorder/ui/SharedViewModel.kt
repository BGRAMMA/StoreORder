package com.bgramma.storeorder.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    val selectedCategoryItem = MutableLiveData<Long>()

    fun selectCategory(id : Long) {
        selectedCategoryItem.value = id
    }
}
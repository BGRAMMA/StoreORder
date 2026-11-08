package com.bgramma.storeorder.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bgramma.storeorder.model.MenuModel
import com.bgramma.storeorder.network.RetrofitClient
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {

    private val _menus = MutableLiveData<List<MenuModel>>()
    val menus: LiveData<List<MenuModel>> get() = _menus

    fun fetchMenus() {
        viewModelScope.launch {

            try {
//                _menus.value = RetrofitClient.menuApi.getMenus()
            } catch (e : Exception) {

            }
        }
    }

}
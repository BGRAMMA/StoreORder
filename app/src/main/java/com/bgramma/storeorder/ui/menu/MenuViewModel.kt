package com.bgramma.storeorder.ui.menu

import android.util.Log
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

    fun fetchMenus(categoryId : Long) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.menuApi.getMenusByCategory(categoryId)

                if ( response.isSuccessful ) {
                    response.body()?.let { menus ->
                        _menus.value = menus
                    }
                }
            } catch (e : Exception) {
                Log.e("API_ERROR", "메뉴 수신 실패 : ${e.message}")
            }
        }
    }

}
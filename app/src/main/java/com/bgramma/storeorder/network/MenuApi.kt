package com.bgramma.storeorder.network

import com.bgramma.storeorder.model.MenuModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MenuApi {
    @GET("/api/categories/{categoryId}/menus")
    suspend fun getMenusByCategory(
        @Path("categoryId") categoryId: Long
    ) : Response<List<MenuModel>>
}
package com.bgramma.storeorder.network

import com.bgramma.storeorder.model.CategoryModel
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApi {
    @GET("/api/categories")
    suspend fun getCategories() : Response<List<CategoryModel>>
}
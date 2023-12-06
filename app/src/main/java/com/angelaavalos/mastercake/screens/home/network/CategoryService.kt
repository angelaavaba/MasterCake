package com.angelaavalos.mastercake.screens.home.network


import com.angelaavalos.mastercake.screens.home.models.Category
import retrofit2.http.GET
import retrofit2.http.Header

interface CategoryService {
    @GET("category")
    suspend fun getCategories(@Header("Authorization")jwt:String): List<Category>
}
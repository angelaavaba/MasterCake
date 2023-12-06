package com.angelaavalos.mastercake.screens.home.network

import com.angelaavalos.mastercake.screens.home.models.Category
import com.angelaavalos.mastercake.screens.login.RetrofitInstance

class CategoryRepository (private val jwt:String){
    private val categoryService = RetrofitInstance.categoryService

    suspend fun getCategories(): List<Category>{
        val formattedToken = "Bearer $jwt"
        return categoryService.getCategories(formattedToken)
    }
}
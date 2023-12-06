package com.angelaavalos.mastercake.screens.home.network

import com.angelaavalos.mastercake.screens.home.models.Product
import com.angelaavalos.mastercake.screens.login.RetrofitInstance

class ProductRepository(private val jwt:String){
    private val productService = RetrofitInstance.productService

    suspend fun getProducts(): List<Product>{
        val formattedToken = "Bearer $jwt"
        return productService.getProducts(formattedToken)
    }

    suspend fun getProductsByCategory(categoryId: String): List<Product> {
        val formattedToken = "Bearer $jwt"
        return productService.getProductsByCategory(formattedToken, categoryId)
    }
}
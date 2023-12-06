package com.angelaavalos.mastercake.screens.home.network

import com.angelaavalos.mastercake.screens.home.models.Product
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ProductService {
    @GET("products")
    suspend fun getProducts(@Header("Authorization")jwt:String): List<Product>

    @GET("products/category/{category}")
    suspend fun getProductsByCategory(@Header("Authorization") jwt: String, @Path("category") categoryId: String): List<Product>

}
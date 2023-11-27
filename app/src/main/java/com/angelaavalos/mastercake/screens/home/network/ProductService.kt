package com.angelaavalos.mastercake.screens.home.network

import com.angelaavalos.mastercake.screens.home.models.Product
import retrofit2.http.GET
import retrofit2.http.Header

interface ProductService {
    @GET("products")
    suspend fun getProducts(@Header("Authorization")jwt:String): List<Product>
}
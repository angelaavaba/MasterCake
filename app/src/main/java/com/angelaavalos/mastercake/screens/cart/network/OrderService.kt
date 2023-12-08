package com.angelaavalos.mastercake.screens.cart.network

import com.angelaavalos.mastercake.screens.cart.models.Order
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OrderService{
    @POST("order")
    suspend fun doOrder(@Header("Authorization")jwt:String, @Body order: Order): Order
}
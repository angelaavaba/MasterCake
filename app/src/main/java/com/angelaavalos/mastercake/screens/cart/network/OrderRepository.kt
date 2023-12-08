package com.angelaavalos.mastercake.screens.cart.network

import com.angelaavalos.mastercake.screens.cart.models.Order
import com.angelaavalos.mastercake.screens.login.RetrofitInstance
import retrofit2.Response

class OrderRepository {
    private val orderService = RetrofitInstance.orderService

    suspend fun createOrder(jwt: String, order: Order): Order {
        return orderService.doOrder(jwt, order)
    }
}

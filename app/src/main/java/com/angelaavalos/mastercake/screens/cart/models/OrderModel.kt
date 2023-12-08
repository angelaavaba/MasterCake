package com.angelaavalos.mastercake.screens.cart.models

data class Order(
    val userId: String,
    val items: List<OrderItem>,
    val totalPrice: Double
)

data class OrderItem(
    val productId: String,
    val quantity: Int
)

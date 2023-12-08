package com.angelaavalos.mastercake.screens.cart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelaavalos.mastercake.screens.cart.models.Order
import com.angelaavalos.mastercake.screens.cart.network.OrderRepository
import kotlinx.coroutines.launch


class OrderViewModel(private val repository: OrderRepository) : ViewModel() {

    private val _orderResult = MutableLiveData<Order>()
    val orderResult: LiveData<Order> = _orderResult

    fun createOrder(jwt: String, order: Order) {
        viewModelScope.launch {
            try {
                val result = repository.createOrder(jwt, order)
                _orderResult.value = result
            } catch (e: Exception) {
                // Handle the exception
            }
        }
    }
}


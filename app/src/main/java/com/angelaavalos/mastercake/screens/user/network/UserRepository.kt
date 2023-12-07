package com.angelaavalos.mastercake.screens.user.network

import com.angelaavalos.mastercake.screens.login.RetrofitInstance
import com.angelaavalos.mastercake.screens.user.models.UserResponse

class UserRepository {

    private val userService = RetrofitInstance.userService

    suspend fun getUser(username: String): UserResponse {
        return userService.getUser(username)
    }
}

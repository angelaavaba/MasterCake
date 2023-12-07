package com.angelaavalos.mastercake.screens.user.network

import com.angelaavalos.mastercake.screens.user.models.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): UserResponse
}
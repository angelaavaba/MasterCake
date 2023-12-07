package com.angelaavalos.mastercake.screens.login.network

import com.angelaavalos.mastercake.screens.login.model.LoginDataBody
import com.angelaavalos.mastercake.screens.login.model.LoginModel
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("users/login")
    suspend fun doLogin(@Body loginData: LoginDataBody): LoginModel

}

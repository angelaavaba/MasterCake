package com.angelaavalos.mastercake.screens.register.network


import com.angelaavalos.mastercake.screens.register.model.RegisterDataBody
import com.angelaavalos.mastercake.screens.register.model.RegisterModel
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("users/registrar")
    suspend fun doRegister(@Body registerData: RegisterDataBody): RegisterModel
}
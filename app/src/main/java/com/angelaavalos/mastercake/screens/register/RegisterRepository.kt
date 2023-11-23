package com.angelaavalos.mastercake.screens.register

import com.angelaavalos.mastercake.screens.login.RetrofitInstance
import com.angelaavalos.mastercake.screens.register.model.RegisterDataBody
import com.angelaavalos.mastercake.screens.register.model.RegisterModel

class RegisterRepository {
    private val registerService = RetrofitInstance.registerService

    suspend fun doRegister(registerData: RegisterDataBody): RegisterModel{

        return registerService.doRegister(registerData)
    }
}
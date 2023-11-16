package com.angelaavalos.mastercake.screens.login

import com.angelaavalos.mastercake.screens.login.model.LoginDataBody
import com.angelaavalos.mastercake.screens.login.model.LoginModel

class LoginRepository {
    private val loginService = RetrofitInstance.loginService

    suspend fun doLogin(loginData: LoginDataBody): LoginModel {

        return loginService.doLogin(loginData)
    }
}
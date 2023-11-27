package com.angelaavalos.mastercake.screens.login.model

data class LoginModel(
    val message: String,
    val jwt: String?
)

data class LoginDataBody(
    val usrn: String,
    val password: String
)
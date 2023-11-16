package com.angelaavalos.mastercake.screens.login.model

data class LoginModel(
    val message: String
)

data class LoginDataBody(
    val usrn: String,
    val password: String
)
package com.angelaavalos.mastercake.screens.register.model

import java.util.Date

data class RegisterModel(
    val message: String
)

data class RegisterDataBody(
    val usrn: String,
    val password: String,
    val domicilio: String,
    val sexo: String
)
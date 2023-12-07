package com.angelaavalos.mastercake.screens.user.models

import com.google.android.gms.auth.api.identity.SignInPassword
import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("_id") val id: String,
    val username: String,
    val password: String,
    val domicilio: String,
    val sexo: String
)

data class UserResponse(
    val message: String,
    val obj: UserModel
)
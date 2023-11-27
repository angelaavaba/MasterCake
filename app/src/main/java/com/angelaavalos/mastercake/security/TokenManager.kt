package com.angelaavalos.mastercake.security

import android.content.Context

object TokenManager {

    private const val TOKEN_KEY = "auth_token"

    fun saveToken(context: Context, token: String) {
        val prefs = SecureStorage.getEncryptedSharedPreferences(context)
        with(prefs.edit()) {
            putString(TOKEN_KEY, token)
            commit()
        }
    }

    fun getToken(context: Context): String? {
        val prefs = SecureStorage.getEncryptedSharedPreferences(context)
        return prefs.getString(TOKEN_KEY, null)
    }
}
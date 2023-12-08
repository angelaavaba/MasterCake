package com.angelaavalos.mastercake.security

import android.content.Context
import android.util.Log

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

    fun clearToken(context: Context) {
        val prefs = SecureStorage.getEncryptedSharedPreferences(context)
        with(prefs.edit()) {
            remove(TOKEN_KEY)
            commit()
        }
        Log.d("TokenManager", "Token cleared successfully")
    }
}
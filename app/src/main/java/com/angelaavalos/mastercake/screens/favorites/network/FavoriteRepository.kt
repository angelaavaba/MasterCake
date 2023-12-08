package com.angelaavalos.mastercake.screens.favorites.network

import com.angelaavalos.mastercake.screens.favorites.models.FavoriteModel
import com.angelaavalos.mastercake.screens.login.RetrofitInstance
import retrofit2.Response


class FavoriteRepository(private val jwt:String){
    private val favoriteService = RetrofitInstance.favoriteService

    suspend fun getUserFavorites(UserId: String): List<FavoriteModel>{
        val formattedToken = "Bearer $jwt"
        return favoriteService.getUserFavorites(formattedToken,UserId)
    }
}


package com.angelaavalos.mastercake.screens.favorites.network

import com.angelaavalos.mastercake.screens.favorites.models.FavoriteModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FavoriteService {

    @GET("favorite/user/{UserId}")
    suspend fun getUserFavorites(@Header("Authorization") jwt: String, @Path("UserId") UserId: String): List<FavoriteModel>
}

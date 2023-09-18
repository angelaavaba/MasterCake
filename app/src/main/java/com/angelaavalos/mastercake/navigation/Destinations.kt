package com.angelaavalos.mastercake.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations (
    val route: String,
    val title: String,
    val icon:  ImageVector
    ){

    object HomeView: Destinations("HomeView","Home", Icons.Filled.Home)
    object FavoritesView: Destinations("FavoritesView","Favorites", Icons.Filled.Favorite)
    object MessagesView: Destinations("MessagesView","Messages", Icons.Filled.Message)
    object CartView: Destinations("CartView","Cart", Icons.Filled.ShoppingCart)
}
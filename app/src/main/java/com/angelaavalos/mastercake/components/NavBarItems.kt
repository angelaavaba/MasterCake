package com.angelaavalos.mastercake.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class BarItem(
    //Titulo de la opcion
    val title: String,
    //Icono de la opcion del menu
    val image: ImageVector,
    //Ruta a la cual se va a dirigir la opción
    val route: String
)

object NavBarItems{
    val NavBarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "HomeView"
        ),
        BarItem(
            title = "Favorites",
            image = Icons.Filled.Favorite,
            route = "FavoritesView"
        ),
        BarItem(
            title = "Messages",
            image = Icons.Filled.Message,
            route = "MessagesView"
        ),
        BarItem(
            title = "Cart",
            image = Icons.Filled.ShoppingCart,
            route = "HomeView"
        )
    )
}

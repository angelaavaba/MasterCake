package com.angelaavalos.mastercake.navigation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.angelaavalos.mastercake.R


    val  NavBarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "homeroute"
        ),
        BarItem(
            title = "Favorites",
            image = Icons.Filled.Favorite,
            route = "favoritesroute"
        ),
        BarItem(
            title = "Notifications",
            image = Icons.Filled.Notifications,
            route = "notificationsroute"
        ),
        BarItem(
            title = "Cart",
            image = Icons.Filled.ShoppingCart,
            route = "cartroute"
        )


    )

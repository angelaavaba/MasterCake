package com.angelaavalos.mastercake.navigation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import com.angelaavalos.mastercake.R


    val  NavBarItems = listOf(
        BarItem(
            title = R.string.Home,
            image = Icons.Filled.Home,
            route = "homeroute"
        ),
        BarItem(
            title = R.string.Favorites,
            image = Icons.Filled.Favorite,
            route = "favoritesroute"
        ),
        BarItem(
            title = R.string.Notifications,
            image = Icons.Filled.Notifications,
            route = "notificationsroute"
        ),
        BarItem(
            title = R.string.Cart,
            image = Icons.Filled.ShoppingCart,
            route = "cartroute"
        ),


    )

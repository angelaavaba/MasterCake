package com.angelaavalos.mastercake.navigation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import com.angelaavalos.mastercake.R


val NavBarItems = listOf(
    BarItem(
        title = R.string.Home,
        image = Icons.Filled.Home,
        route = "homeroute"
    ),
    BarItem(
        title = R.string.Promo,
        image = Icons.Filled.Discount,
        route = "favoritesroute"
    ),
    BarItem(
        title = R.string.Cart,
        image = Icons.Filled.ShoppingCart,
        route = "cartroute"
    ),
    BarItem(
        title = R.string.User,
        image = Icons.Filled.AccountBox,
        route = "userroute"
    ),


    )

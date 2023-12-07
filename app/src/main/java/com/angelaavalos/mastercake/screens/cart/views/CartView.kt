package com.angelaavalos.mastercake.screens.cart.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.navigation.components.BottomNavBar
import com.angelaavalos.mastercake.screens.login.LoginViewModel


@Composable
fun CartView(navController: NavController){
    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(id = R.string.Cart)) }) },
        content = { it
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1.0f)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(150.dp)
                            .align(Alignment.Center)

                    )
                }

            }
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}


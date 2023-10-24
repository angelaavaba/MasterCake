package com.angelaavalos.mastercake.screens.cart

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.angelaavalos.mastercake.navigation.components.BottomNavBar

@Composable
fun CartView(navController : NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Carrito") }) },
        content = { it
            Column {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "",
                        tint = Color.Black,
                        modifier = Modifier.size(150.dp)
                            .align(Alignment.Center)

                    )
                }

            }
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}
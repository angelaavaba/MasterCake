package com.angelaavalos.mastercake.screens.cart.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.navigation.components.BottomNavBar
import com.angelaavalos.mastercake.screens.cart.viewmodel.OrderViewModel
import com.angelaavalos.mastercake.screens.login.LoginViewModel


@Composable
fun CartView(navController: NavController){
    var userId by remember { mutableStateOf("") }
    var productId by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var jwtToken by remember { mutableStateOf("") }
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(id = R.string.Cart)) }) },
        content = { it
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Create New Order", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = userId,
                    onValueChange = { userId = it },
                    label = { Text("User ID") }
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = productId,
                    onValueChange = { productId = it },
                    label = { Text("Product ID") }
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = quantity,
                    onValueChange = { quantity = it },
                    label = { Text("Quantity") }
                )

                Spacer(modifier = Modifier.height(8.dp))


                Button(onClick = { }) {
                    Text("Submit Order")
                }


            }
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}

package com.angelaavalos.mastercake.screens.favorites

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.angelaavalos.mastercake.navigation.components.BottomNavBar
import com.angelaavalos.mastercake.R

@Composable
fun FavoritesView(navController: NavController){
    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(id = R.string.Favorites)) }) },
        content = { it
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1.0f)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
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
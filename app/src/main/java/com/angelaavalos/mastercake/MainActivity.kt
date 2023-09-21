package com.angelaavalos.mastercake

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.components.BottomNavBar
import com.angelaavalos.mastercake.navigation.Destinations
import com.angelaavalos.mastercake.navigation.NavigationHost


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()

        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()

    val navigationItems = listOf(
        Destinations.HomeView,
        Destinations.FavoritesView,
        Destinations.MessagesView,
        Destinations.CartView
    )
    Scaffold(
        bottomBar = { BottomNavBar(navController = navController, items = navigationItems)}
    ){
        NavigationHost(navController)
    }
}
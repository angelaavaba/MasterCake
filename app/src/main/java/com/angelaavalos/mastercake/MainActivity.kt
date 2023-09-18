package com.angelaavalos.mastercake

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.components.BottomNavBar
import com.angelaavalos.mastercake.navigation.Destinations
import com.angelaavalos.mastercake.navigation.NavigationHost
import com.angelaavalos.mastercake.screens.FavoritesView
import com.angelaavalos.mastercake.ui.theme.MASTERCAKETheme

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
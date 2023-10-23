package com.angelaavalos.mastercake

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.components.BottomNavBar
import com.angelaavalos.mastercake.navigation.Destinations
import com.angelaavalos.mastercake.screens.onboarding.OnboardingScreen
import com.google.accompanist.pager.ExperimentalPagerApi


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
    @SuppressLint(
        "UnusedMaterialScaffoldPaddingParameter",
        "UnusedMaterial3ScaffoldPaddingParameter"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            val navigationItems = listOf(
                Destinations.HomeView,
                Destinations.FavoritesView,
                Destinations.MessagesView,
                Destinations.CartView
            )
            Scaffold(
                bottomBar = {
                    BottomNavBar(navController = navController, items = navigationItems)
                }
            ) {
                //  NavigationHost(navController)
                OnboardingScreen()
            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val navigationItems = listOf(
        Destinations.HomeView,
        Destinations.FavoritesView,
        Destinations.MessagesView,
        Destinations.CartView
    )
    Scaffold(
        bottomBar = { BottomNavBar(navController = navController, items = navigationItems) }
    ) {
        //NavigationHost(navController)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    OnboardingScreen()
}

package com.angelaavalos.mastercake.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.angelaavalos.mastercake.screens.HomeView
import com.angelaavalos.mastercake.navigation.Destinations.*
import com.angelaavalos.mastercake.screens.CartView
import com.angelaavalos.mastercake.screens.FavoritesView
import com.angelaavalos.mastercake.screens.MessagesView

@Composable
fun NavigationHost(
    navController: NavHostController
){

    NavHost(navController = navController, startDestination = HomeView.route){
        composable(HomeView.route){
            com.angelaavalos.mastercake.screens.HomeView()
        }
        composable(FavoritesView.route){
            com.angelaavalos.mastercake.screens.FavoritesView()
        }
        composable(MessagesView.route){
            com.angelaavalos.mastercake.screens.MessagesView()
        }
        composable(CartView.route){
            com.angelaavalos.mastercake.screens.CartView()
        }
    }
}
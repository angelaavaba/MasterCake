package com.angelaavalos.mastercake.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.angelaavalos.mastercake.navigation.Destinations.*
import com.angelaavalos.mastercake.screens.*

@Composable
fun NavigationHost(
    navController: NavHostController
){

    NavHost(navController = navController, startDestination = HomeView.route){
        composable(HomeView.route){
            com.angelaavalos.mastercake.screens.HomeView(homeViewModel = viewModel())
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
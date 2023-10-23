package com.angelaavalos.mastercake.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.angelaavalos.mastercake.navigation.NavRoutes.*
import com.angelaavalos.mastercake.screens.*
import com.angelaavalos.mastercake.screens.HomeView
import com.angelaavalos.mastercake.screens.home.viewmodel.HomeViewModel



@Composable
fun NavigationHost(navController: NavHostController){
    NavHost(navController, startDestination = NavRoutes.Home.route){

        composable(Home.route){
            HomeView(homeViewModel = HomeViewModel(), navController = navController)
        }
        composable(FavoritesView.route){
           FavoritesView()
        }
        composable(NotificationsView.route){
            MessagesView()
        }
        composable(CartView.route){
           CartView()
        }
    }
}
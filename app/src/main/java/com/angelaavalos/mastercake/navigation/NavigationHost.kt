package com.angelaavalos.mastercake.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.angelaavalos.mastercake.navigation.Destinations.*
import com.angelaavalos.mastercake.screens.*
import com.angelaavalos.mastercake.screens.HomeView
import com.angelaavalos.mastercake.navigation.Destinations
import com.angelaavalos.mastercake.screens.home.viewmodel.HomeViewModel


@SuppressLint("UnsafeOptInUsageError")
@Composable
fun NavigationHost(navController: NavHostController){
    NavHost(navController = navController, startDestination = HomeView.route){

        composable(HomeView.route){
            HomeView(homeViewModel = HomeViewModel(), navController = navController)
        }
        composable(FavoritesView.route){
           FavoritesView()
        }
        composable(MessagesView.route){
            MessagesView()
        }
        composable(CartView.route){
           CartView()
        }
    }
}
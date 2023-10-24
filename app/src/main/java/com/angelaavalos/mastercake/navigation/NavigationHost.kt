package com.angelaavalos.mastercake.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.angelaavalos.mastercake.navigation.NavRoutes.*
import com.angelaavalos.mastercake.screens.HomeView
import com.angelaavalos.mastercake.screens.cart.CartView
import com.angelaavalos.mastercake.screens.favorites.FavoritesView
import com.angelaavalos.mastercake.screens.home.viewmodel.HomeViewModel
import com.angelaavalos.mastercake.screens.loginregister.LogInRegisterView
import com.angelaavalos.mastercake.screens.login.LoginView
import com.angelaavalos.mastercake.screens.notifications.MessagesView
import com.angelaavalos.mastercake.screens.onboarding.OnboardingScreen
import com.angelaavalos.mastercake.screens.register.RegisterView


@Composable
fun NavigationHost(navController: NavHostController){

    NavHost(navController, startDestination = NavRoutes.Onboarding.route) {

        composable(Home.route) {
            HomeView(homeViewModel = HomeViewModel(), navController = navController)
        }
        composable(FavoritesView.route){
           FavoritesView(navController = navController)
        }
        composable(NotificationsView.route){
            MessagesView(navController = navController)
        }
        composable(CartView.route){
           CartView(navController = navController)
        }

        composable(Register.route){
            RegisterView(navController = navController)
        }

        composable(Onboarding.route){
            OnboardingScreen(navController = navController)
        }

        composable(LoginView.route){
            LoginView(navController = navController)
        }

        composable(LoginRegisterView.route){
            LogInRegisterView(navController = navController)
        }
    }
}
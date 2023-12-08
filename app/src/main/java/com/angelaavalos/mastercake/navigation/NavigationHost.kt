package com.angelaavalos.mastercake.navigation

import android.net.Uri
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.angelaavalos.mastercake.navigation.NavRoutes.*
import com.angelaavalos.mastercake.screens.HomeView
import com.angelaavalos.mastercake.screens.cart.views.CartView
import com.angelaavalos.mastercake.screens.favorites.FavoritesView
import com.angelaavalos.mastercake.screens.favorites.models.FavoriteViewModelFactory
import com.angelaavalos.mastercake.screens.favorites.viewmodel.FavoriteViewModel
import com.angelaavalos.mastercake.screens.home.viewmodel.HomeViewModel
import com.angelaavalos.mastercake.screens.loginregister.LogInRegisterView
import com.angelaavalos.mastercake.screens.login.LoginView
import com.angelaavalos.mastercake.screens.login.LoginViewModel
import com.angelaavalos.mastercake.screens.onboarding.OnboardingScreen
import com.angelaavalos.mastercake.screens.register.RegisterView
import com.angelaavalos.mastercake.screens.register.RegisterViewModel
import com.angelaavalos.mastercake.screens.splashscreen.SplashScreen
import com.angelaavalos.mastercake.screens.user.AboutView
import com.angelaavalos.mastercake.screens.user.UsersView
import com.angelaavalos.mastercake.screens.utils.PreferenceManager
import com.angelaavalos.mastercake.security.TokenManager


@Composable
fun NavigationHost(navController: NavHostController, homeViewModel: HomeViewModel) {
    val context = LocalContext.current
    val preferenceManager = remember { PreferenceManager(context) }
    val alreadyShowOnboarding = remember {
        mutableStateOf(preferenceManager.getData("alreadyShowOnboarding", false))
    }


    NavHost(
        navController, startDestination = if (!alreadyShowOnboarding.value) {
            NavRoutes.Onboarding.route
        } else {
            NavRoutes.SplashView.route
        }
    ) {

        composable(Home.route) {
            HomeView(homeViewModel = homeViewModel, navController = navController)
        }
        composable(FavoritesView.route) {
            val videoUris = listOf(
                Uri.parse("android.resource://com.angelaavalos.mastercake/raw/cheesecake_shop"),
                Uri.parse("android.resource://com.angelaavalos.mastercake/raw/chocolateletycake_ad"),
                Uri.parse("android.resource://com.angelaavalos.mastercake/raw/donut_ad"),
                Uri.parse("android.resource://com.angelaavalos.mastercake/raw/cakebroll_ad")



                // Add more URIs as needed
            )

            FavoritesView(navController = navController, videoUris = videoUris)
        }
        composable(CartView.route) {
            CartView(navController = navController
            )
        }

        composable(Register.route) {
            RegisterView(navController = navController, viewModel = RegisterViewModel())
        }

        composable(Onboarding.route) {
            OnboardingScreen(navController = navController)
        }

        composable(LoginView.route) {
            LoginView(navController = navController, viewModel = LoginViewModel())
        }

        composable(LoginRegisterView.route) {
            LogInRegisterView(navController = navController)
        }
        composable(UsersView.route) {
            UsersView(navController = navController, context = context)


        }
        composable(SplashView.route) {
            SplashScreen(navController = navController)


        }
        composable(AboutView.route) {
            AboutView(navController = navController)
        }
    }
}

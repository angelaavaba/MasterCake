@file:OptIn(ExperimentalPagerApi::class)

package com.angelaavalos.mastercake

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.angelaavalos.mastercake.screens.RegisterView
import com.angelaavalos.mastercake.ui.theme.MASTERCAKETheme
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.navigation.NavRoutes
import com.angelaavalos.mastercake.navigation.components.NavBarItems
import com.angelaavalos.mastercake.screens.HomeView
import com.angelaavalos.mastercake.screens.home.viewmodel.HomeViewModel
import com.angelaavalos.mastercake.screens.onboarding.OnboardingScreen

class MainActivity : ComponentActivity() {

    @SuppressLint("UnsafeOptInUsageError")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    OnboardingScreen()
                 //   MainScreen()

                }

        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(title = { Text("MASTER CAKE") }) },
        content = { it
            NavigationHost(navController = navController)
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}

@Preview(showBackground = true)
@Composable

fun DefaultPreview() {
    MASTERCAKETheme() {
        //MainScreen()
        //RegisterView(navController)
        OnboardingScreen()
    }

}
@Composable
fun NavigationHost(navController: NavHostController){
    NavHost(navController = navController, startDestination = NavRoutes.Home.route) {

        composable(NavRoutes.Home.route){
            HomeView(homeViewModel = HomeViewModel())
        }
        composable(NavRoutes.RegisterView.route){
            RegisterView()
        }
        composable(NavRoutes.OnboardingView.route){
            OnboardingScreen()
        }
        composable(NavRoutes.Prueba.route){
            Text(text = "Ya porfavor")
        }

    }
}
@Composable

fun BottomNavBar(navController: NavHostController) {
    BottomNavigation {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.forEach { navItem ->

            BottomNavigationItem(

                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = navItem.image,
                        contentDescription = navItem.title.toString()
                    )
                },
                label = {
                    Text(text = navItem.title)
                }
            )

        }
    }
}




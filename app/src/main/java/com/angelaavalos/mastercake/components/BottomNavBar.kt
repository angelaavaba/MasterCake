package com.angelaavalos.mastercake.components

import android.graphics.drawable.Icon



import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.angelaavalos.mastercake.navigation.Destinations



@Composable
fun BottomNavBar(
    navController: NavController,
    items: List<Destinations>
){
    val currentRoute = currentRoute(navController)

    BottomNavigation() {
        items.forEach{ screen ->
            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }

                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = false

            )


        }
    }
}

@Composable
private fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route

}

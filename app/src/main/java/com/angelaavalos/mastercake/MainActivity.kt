@file:OptIn(ExperimentalPagerApi::class)

package com.angelaavalos.mastercake

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.angelaavalos.mastercake.screens.RegisterView
import com.angelaavalos.mastercake.ui.theme.MASTERCAKETheme
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.navigation.NavigationHost
import com.angelaavalos.mastercake.navigation.components.BottomNavBar

class MainActivity : ComponentActivity() {
    @SuppressLint("UnsafeOptInUsageError")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    //  NavigationHost(navController)
                    //OnboardingScreen()
                    val navController = rememberNavController()
                    RegisterView(navController = navController)
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
        MainScreen()
        val navController = rememberNavController()
        //RegisterView(navController = navController)
        //OnboardingScreen()
    }

}



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
import com.google.accompanist.pager.ExperimentalPagerApi
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.navigation.NavigationHost
import com.angelaavalos.mastercake.navigation.components.BottomNavBar


class MainActivity : ComponentActivity() {
    @SuppressLint("UnsafeOptInUsageError")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavigationHost(navController)
                }

        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(title = { Text("MASTER CAKE Angela") }) },
        content = { it
            NavigationHost(navController = navController)
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}


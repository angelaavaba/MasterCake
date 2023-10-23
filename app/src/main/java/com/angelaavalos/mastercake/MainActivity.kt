package com.angelaavalos.mastercake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
<<<<<<< HEAD
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
=======
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
>>>>>>> 0b26eca6c6232e7de7dea3e35179d9b7a88315da
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
<<<<<<< HEAD
import com.angelaavalos.mastercake.components.BottomNavBar
import com.angelaavalos.mastercake.navigation.Destinations
import com.angelaavalos.mastercake.screens.onboarding.OnboardingScreen
import com.google.accompanist.pager.ExperimentalPagerApi


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
    @SuppressLint(
        "UnusedMaterialScaffoldPaddingParameter",
        "UnusedMaterial3ScaffoldPaddingParameter"
    )
=======
import com.angelaavalos.mastercake.navigation.NavigationHost



class MainActivity : ComponentActivity() {
>>>>>>> 0b26eca6c6232e7de7dea3e35179d9b7a88315da
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            Surface(modifier = Modifier.fillMaxSize()
            ) {
<<<<<<< HEAD
                //  NavigationHost(navController)
                OnboardingScreen()
            }
=======
>>>>>>> 0b26eca6c6232e7de7dea3e35179d9b7a88315da

            }

        }
    }
}

<<<<<<< HEAD
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
=======
>>>>>>> 0b26eca6c6232e7de7dea3e35179d9b7a88315da
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    NavigationHost(navController = navController)
}

@Preview(showBackground = true)
@Composable
<<<<<<< HEAD
fun DefaultPreview() {
=======
fun DefaultPreview5(){
    MainScreen()

>>>>>>> 0b26eca6c6232e7de7dea3e35179d9b7a88315da

    OnboardingScreen()
}



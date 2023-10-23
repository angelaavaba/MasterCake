package com.angelaavalos.mastercake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.navigation.NavigationHost



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            Surface(modifier = Modifier.fillMaxSize()
            ) {

            }

        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    NavigationHost(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5(){
    MainScreen()


}



package com.angelaavalos.mastercake.screens.splashscreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.R
import kotlinx.coroutines.delay


@Composable

fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary)// Fondo azul claro
            .padding(top = 200.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logobueno),
            contentDescription = "Imagen del logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

    }
}


@Preview
@Composable
fun SplashScreenPreview() {


}

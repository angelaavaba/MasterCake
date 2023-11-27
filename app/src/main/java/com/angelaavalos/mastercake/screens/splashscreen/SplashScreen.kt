package com.angelaavalos.mastercake.screens.splashscreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.navigation.NavRoutes
import com.angelaavalos.mastercake.screens.utils.PreferenceManager
import kotlinx.coroutines.delay






@Composable

fun SplashScreen(navController: NavController) {
    val context = LocalContext.current

    val preferenceManager = remember { PreferenceManager(context) }

    val alreadyShowOnboarding = remember {
        mutableStateOf(preferenceManager.getData("alreadyShowOnboarding",false))
    }
    LaunchedEffect(key1 = "navegacion") {
        delay(1500)

        if (alreadyShowOnboarding.value) {
            navController.navigate(NavRoutes.LoginRegisterView.route) {
                popUpTo(NavRoutes.SplashView.route) {
                    inclusive = true
                }
            }
        } else {
            navController.navigate(NavRoutes.Onboarding.route) {
                popUpTo(NavRoutes.SplashView.route) {
                    inclusive = true
                }
            }
        }


    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.yellow)) // Fondo amarillo
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

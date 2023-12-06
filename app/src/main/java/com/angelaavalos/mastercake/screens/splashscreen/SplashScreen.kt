package com.angelaavalos.mastercake.screens.splashscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.navigation.NavRoutes
import com.angelaavalos.mastercake.screens.utils.PreferenceManager
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable

fun SplashScreen(navController: NavController) {

    val context = LocalContext.current
    val preferenceManager = remember { PreferenceManager(context) }
    val alreadyShowOnboarding = remember {
        mutableStateOf(preferenceManager.getData("alreadyShowOnboarding",false))
    }
    LaunchedEffect(key1 = "navegacion") {
        delay(3000)

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
    val lottieComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.pastelanimation)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white)),
        contentAlignment = Alignment.Center
    ) {
        LottieAnimation(
            lottieComposition,
            modifier = Modifier.size(450.dp)
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {


}

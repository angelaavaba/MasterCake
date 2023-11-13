package com.angelaavalos.mastercake.screens.loginregister

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.navigation.NavRoutes

@Composable

fun LogInRegisterView(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary) // Fondo azul claro
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logobueno),
                contentDescription = "Imagen del logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(35.dp),
                horizontalArrangement = Arrangement.SpaceBetween
                
            ) {
                Button(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(NavRoutes.LoginView.route)
                    },
                    modifier = Modifier
                        .height(60.dp)
                        .width(170.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Text(text = stringResource(id = R.string.button_login), color = MaterialTheme.colors.secondary)
                }
                Button(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(NavRoutes.Register.route)
                    },
                    modifier = Modifier
                        .height(60.dp)
                        .width(170.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)

                ) {
                    Text(text = stringResource(id = R.string.button_register), color = MaterialTheme.colors.secondary)
                }
            }
        }
    }
}

@Preview
@Composable

fun LogInRegisterPreview() {
    val navController = rememberNavController()

    LogInRegisterView(navController = navController)

}

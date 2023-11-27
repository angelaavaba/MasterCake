package com.angelaavalos.mastercake.screens.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.angelaavalos.mastercake.navigation.components.BottomNavBar
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.navigation.NavRoutes


@Composable
fun UsersView(navController: NavController){
    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(id = R.string.User)) }) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Imagen circular
                val image: Painter = painterResource(id = R.drawable.user) // Reemplazar con tu recurso de imagen
                Image(
                    painter = image,
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Contenido de la interfaz de usuario
                Text("Contenido de la interfaz de usuario")

                Spacer(modifier = Modifier.weight(1f))

                // Botón de cerrar sesión
                Button(
                    onClick = {navController.navigate(NavRoutes.LoginRegisterView.route)},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
                ) {
                    Text("Cerrar Sesión", color = Color.White)
                }
            }
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}
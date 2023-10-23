package com.angelaavalos.mastercake.screens.onboarding

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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.angelaavalos.mastercake.R



@Composable
fun LogInRegisterView () {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue) // Fondo azul claro
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = "Imagen del logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Acción cuando se hace clic en Registrarse */ },
                    modifier = Modifier
                        .height(40.dp)
                        .width(170.dp)
                ) {
                    Text(text = "Ingresar")
                }
                Button(
                    onClick = { /* Acción cuando se hace clic en Ingresar */ },
                    modifier = Modifier
                        .height(40.dp)
                        .width(170.dp)
                ) {
                    Text(text = "Registrarse")
                }
            }
        }
    }
}

@Preview
@Composable
fun LogInRegisterPreview() {
 LogInRegisterView()

}

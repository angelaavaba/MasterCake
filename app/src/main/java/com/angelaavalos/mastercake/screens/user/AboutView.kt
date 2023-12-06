package com.angelaavalos.mastercake.screens.user

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.angelaavalos.mastercake.R
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable
fun AboutView(navController: NavController) {
    var selectedProfileUrl by remember { mutableStateOf<String?>(null) }
    val lottieComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.pastelanimation2))

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.User)) }
            )
        },
        bottomBar = { BottomNavBar(navController = navController) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Proyecto Master Cake",
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.onBackground
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Endulza tu día con nuestra aplicación de tienda en línea para pasteles personalizados. Diseñada con un toque de elegancia y facilidad de uso, nuestra app te invita a explorar una exquisita variedad de opciones para personalizar tus pasteles. Ya sea para una ocasión especial o simplemente para darte un gusto, podrás elegir entre una amplia gama de sabores, decoraciones y tamaños. Con nuestra interfaz intuitiva, personalizar tu pastel es un proceso sencillo y placentero. Además, ofrecemos la comodidad de elegir entre recoger tu pedido en tienda o recibirlo directamente en tu domicilio. Vive una experiencia dulce y única, todo desde la palma de tu mano.",
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Programación de dispositivos móviles 1", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Equipo:", fontSize = 16.sp)

                    MemberInfoRow("Salvador Escalera Robles", "https://github.com/RoblesG935") {
                        selectedProfileUrl = it
                    }
                    Text(text = "Estudiante de Ingeniería en Tecnologías de la Información y Telecomunicaciones")
                    Text(text = "Matrícula: 11025/ Séptimo Semestre")

                    MemberInfoRow("Angela Avalos Baquera", "https://github.com/angelaavaba") {
                        selectedProfileUrl = it
                    }
                    Text(text = "Estudiante de Ingeniería en Tecnologías de la Información y Telecomunicaciones")
                    Text(text = "Matrícula: 11074/ Séptimo Semestre")

                    Spacer(modifier = Modifier.weight(1f))

                    LottieAnimation(
                        lottieComposition,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .size(185.dp),
                        iterations = LottieConstants.IterateForever
                    )
                }
            }
        }
    }
}

@Composable
fun MemberInfoRow(name: String, githubUrl: String, onProfileSelected: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(imageVector = Icons.Default.Person, contentDescription = "Icono de estudiante")
        Spacer(modifier = Modifier.width(8.dp))
        MemberInfo(name, githubUrl, onProfileSelected)
    }
}

@Composable
fun BottomNavBar(navController: NavController) {

    BottomNavigation { com.angelaavalos.mastercake.navigation.components.BottomNavBar(navController = navController) }
}
@Composable
fun MemberInfo(name: String, githubUrl: String, onProfileSelected: (String) -> Unit) {
    val context = LocalContext.current
    val annotatedString = buildAnnotatedString {
        append(name)
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append(" (Github)")
        }
    }
    ClickableText(
        text = annotatedString,
        onClick = {
            onProfileSelected(githubUrl)
            openUrlInBrowser(context, githubUrl)
        }
    )
}

fun openUrlInBrowser(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(url)
    }
    context.startActivity(intent)
}






package com.angelaavalos.mastercake.screens.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.navigation.NavRoutes
import com.angelaavalos.mastercake.navigation.components.BottomNavBar

@Composable
fun UsersView(navController: NavController) {
    val lottieComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.pastelanimation3))

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.User)) },
                actions = {
                    IconButton(
                        onClick = {navController.navigate(NavRoutes.AboutView.route)}
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Acerca de",
                            tint = Color.White
                        )
                    }
                }
            )
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val image: Painter = painterResource(id = R.drawable.user)
                    Image(
                        painter = image,
                        contentDescription = "",
                        modifier = Modifier
                            .size(200.dp, 200.dp)
                            .clip(CircleShape)
                            .background(Color.Gray)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "User interface",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        elevation = 4.dp
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Green)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("User Active")
                            }

                            Text(
                                "Contact Information",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = "Email",
                                    tint = Color.Gray
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "salvadorer935@gmail.com",
                                    fontSize = 18.sp,
                                    color = Color.Gray
                                )
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = "Email",
                                    tint = Color.Gray
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "angelaavalos@gmail.com",
                                    fontSize = 18.sp,
                                    color = Color.Gray
                                )
                            }

                            Button(
                                onClick = { navController.navigate(NavRoutes.LoginRegisterView.route) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
                            ) {
                                Text("Log Out", color = Color.White)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))


                }

                // Animación Lottie en la parte inferior
                LottieAnimation(
                    lottieComposition,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .size(185.dp), iterations = LottieConstants.IterateForever
                )
            }
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}






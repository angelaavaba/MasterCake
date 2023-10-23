package com.angelaavalos.mastercake.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angelaavalos.mastercake.R
import kotlinx.coroutines.launch
import com.angelaavalos.mastercake.ui.theme.MASTERCAKETheme



@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val onboarding = listOf(
            "Disfruta nuestros postres",
            "Desafia tu paldar",
            "Conoce nuestras especialidades"
        )
        val onboarding2 = listOf(
            "Los mejores del mundo",
            "Prueba nuestras recomendaciones",
            "Asegurate de probar todas las especialidades"
        )
        val onboardingImages = listOf(
            painterResource(id = R.drawable.pastel1),
            painterResource(id = R.drawable.pastel2),
            painterResource(id = R.drawable.pastel3)
        )
        val state = rememberPagerState(pageCount = { onboarding.size })
        val scope = rememberCoroutineScope()

        Box {
            HorizontalPager(state = state) { page ->
                if (page == 0) {
                    // Primera página con el diseño original
                    Image(
                        painter = onboardingImages[page],
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 16.dp, bottom = 150.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = onboarding[page],
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp
                        )
                        Text(
                            text = onboarding2[page],
                            color = Color.White,
                            fontWeight = FontWeight.Light,
                            fontSize = 24.sp
                        )
                    }
                } else {
                    // Segunda y tercera página con diseño nuevo
                    Column(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                        ) {
                            Image(
                                painter = onboardingImages[page],
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth(),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = onboarding[page],
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 32.sp
                                )
                                Text(
                                    text = onboarding2[page],
                                    color = Color.Black,
                                    fontWeight = FontWeight.Light,
                                    fontSize = 24.sp
                                )
                            }
                        }
                    }
                }
            }

            // Botones de navegación
            if (state.currentPage != onboarding.size - 1) {
                Button(
                    onClick = { scope.launch { state.animateScrollToPage(state.currentPage + 1) } },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp),
                    colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.White, contentColor = Color.Black)
                ) {
                    Text(text = "Next")
                }
                MASTERCAKETheme() {

                    Button(
                        onClick = {
                            scope.launch {
                                state.animateScrollToPage(onboarding.size - 1)
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp),
                        colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.White, contentColor = Color.Black)

                    ) {
                        Text(text = "Skip")
                    }
                }
            } else {
                Button(
                    onClick = {
                        // Acción cuando se presiona "Empezar"
                    },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 50.dp),
                    colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.White, contentColor = Color.Black)
                ) {
                    Text(text = "Empezar")
                }
            }

            // Indicadores de página
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                repeat(onboarding.size) {
                    val color = if (state.currentPage == it) Color.Black else Color.White

                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(12.dp)
                            .background(color)
                    )
                }
            }
        }
    }
}
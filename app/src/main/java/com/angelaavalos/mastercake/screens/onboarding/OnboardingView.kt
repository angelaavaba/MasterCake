package com.angelaavalos.mastercake.screens.onboarding


import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

data class OnBoardingData(val image: Int, val title: String, val desc: String)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingView(navController: NavController) {
    val items = ArrayList<OnBoardingData>()

    items.add(
        OnBoardingData(
            R.drawable.fondo,
            "DISFRUTA NUESTROS POSTRES",
            "los mejores del mundo"
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.fondo,
            "DESAFIA TU PALADAR",
            "Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface."
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.fondo,
            "CONOCE NUESTRAS ESPECIALIDADES",
            "Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface."
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier.fillMaxSize(),
        navController = navController
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = item[pagerState.currentPage].image),
            contentDescription = item[pagerState.currentPage].title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Spacer(modifier = Modifier.height(200.dp)) // <-- Aumentamos aún más la altura del Spacer

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = item[pagerState.currentPage].title,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = Color.White
            )

            Text(
                text = item[pagerState.currentPage].desc,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(50.dp)) // <-- Aumentamos la altura del Spacer para más espacio

            PagerIndicator(item.size, pagerState.currentPage)
        }

        BottomSection(pagerState.currentPage, pagerState, navController = navController)
    }
}
@Composable
fun PagerIndicator(size: Int, currentPage: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 60.dp)
    ) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) Color.Red else Color.Blue.copy(alpha = 0.5f)
            )
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomSection(currentPager: Int, pagerState: PagerState, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp, start = 16.dp, end = 16.dp),  // <-- Disminuimos el padding inferior
        contentAlignment = Alignment.BottomEnd
    ) {
        // Si es la última página, añade el botón "Empezar" y oculta los demás
        if (currentPager == pagerState.pageCount - 1) {
            Button(
                onClick = { /* Acción al presionar "Empezar" */ },
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text("Empezar")
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SkipNextButton(text = "Skip", pagerState = pagerState, navController = navController)
                SkipNextButton(text = "Next", pagerState = pagerState, navController = navController)
            }
        }
    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SkipNextButton(text: String, pagerState: PagerState, navController: NavController) {
    val coroutineScope = rememberCoroutineScope()

    if (text == "Skip" && pagerState.currentPage == pagerState.pageCount - 1) {
        // No mostrar el botón "Skip" en la última página
        return
    }

    val backgroundColor = if (text == "Skip") Color.Gray else Color.Black
    val textColor = Color.White

    Button(
        onClick = {
            if (text == "Skip") {
                // Cambiar a la última página al hacer clic en "Skip"
                val lastPage = pagerState.pageCount - 1
                if (lastPage >= 0) {
                    coroutineScope.launch {
                        pagerState.scrollToPage(lastPage)
                    }
                }
            } else if (text == "Next") {
                // Cambiar a la siguiente página al hacer clic en "Next"
                val nextPage = pagerState.currentPage + 1
                if (nextPage < pagerState.pageCount) {
                    coroutineScope.launch {
                        pagerState.scrollToPage(nextPage)
                    }
                }
            }
        },
        modifier = Modifier
            .padding(16.dp)
            .background(backgroundColor, shape = CircleShape),
        contentPadding = PaddingValues(12.dp),
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 18.sp,
            style = MaterialTheme.typography.button,
            fontWeight = FontWeight.Medium
        )
    }
}

@ExperimentalPagerApi
@Preview
@Composable
fun OnboardingPreview() {
    OnboardingView(navController = rememberNavController())
}

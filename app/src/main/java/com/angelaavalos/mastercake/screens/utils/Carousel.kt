package com.angelaavalos.mastercake.screens.utils

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.angelaavalos.mastercake.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


data class carouselImages( val image : Int)

@Composable
fun ImageSlider(images: List<Any>) {
    var currentImageIndex by remember { mutableStateOf(0) }
    var isAnimating by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.weight(1f).height(100.dp)
            .fillMaxWidth().padding(16.dp)) {
            // Scrollable Row of Cards
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(images) { index, image ->
                    Card(
                        modifier = Modifier
                            .width(300.dp)
                            .height(200.dp)
                            .clickable {
                                if (index != currentImageIndex && !isAnimating) {
                                    isAnimating = true
                                    coroutineScope.launch {
                                        val delayMillis = 500L
                                        // Wait for the card to change color before animating
                                        delay(delayMillis / 2)
                                        currentImageIndex = index
                                        delay(delayMillis)
                                        isAnimating = false
                                    }
                                }
                            },
                        elevation = 4.dp
                    ) {
                    }
                }

            }

        }
    }
}

val images = listOf(
    carouselImages(
        image = R.drawable.vainillafresa
    ),
    carouselImages(
        image = R.drawable.chocolima
    ),
    carouselImages(
        image = R.drawable.redvelvet
    )

)
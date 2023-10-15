package com.angelaavalos.mastercake.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun HomeView(homeViewModel: HomeViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val products = homeViewModel.products
            items(products.windowed(2,2, partialWindows = true)){
                productPair ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (product in productPair){
                        ProductsItem(product)
                    }

                }

            }
        }
    }

}

@Composable
fun ProductsItem(product: HomeViewModel.Product) {
    Card(
        modifier = Modifier
            .width(180.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = MaterialTheme.shapes.medium)
            )
            Text(
                text = product.name,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Text(
                text = product.precio.toString(),
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }

    }
}
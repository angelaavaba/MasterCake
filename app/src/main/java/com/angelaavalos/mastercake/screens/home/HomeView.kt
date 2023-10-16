package com.angelaavalos.mastercake.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.angelaavalos.mastercake.screens.home.HomeViewModel


@Composable
fun HomeView(homeViewModel: HomeViewModel) {

    val selectedProduct = remember { mutableStateOf(null as HomeViewModel.Product?) }


    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(homeViewModel.categories) { category ->
                    CategoriesItem(category)
                }
            }
        }
        items(homeViewModel.products.windowed(2, 2, partialWindows = true)) { productPair ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (product in productPair) {
                    ProductsItem(product){
                        selectedProduct.value = product

                    }
                }
            }
        }

    }
    selectedProduct.value?.let { product ->
        ProductDescriptionDialog(product, onDismiss = { selectedProduct.value = null })
    }
}

@Composable
fun ProductsItem(product: HomeViewModel.Product, onProductClick: ()->Unit) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .clickable { onProductClick() }
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
                text = product.price.toString() + "MXN",
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }

    }
}
@Composable
fun ProductDescriptionDialog(product: HomeViewModel.Product, onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .background(Color.White)
                .clip(shape = MaterialTheme.shapes.small)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                Text(
                    text = product.price.toString() + "MXN",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun CategoriesItem(category: HomeViewModel.Categories) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .padding(8.dp)
            .border(1.dp, color = MaterialTheme.colors.primary, shape = MaterialTheme.shapes.small)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = category.icon,
                contentDescription = null,
                tint = MaterialTheme.colors.primary,
                modifier = Modifier
                    .size(100.dp)
                    .fillMaxWidth()
                    .clip(shape = MaterialTheme.shapes.small)



            )
            Text(
                text = category.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center
            )

        }

    }
}



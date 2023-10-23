package com.angelaavalos.mastercake.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.angelaavalos.mastercake.components.BottomNavBar
import com.angelaavalos.mastercake.screens.home.viewmodel.HomeViewModel
import com.angelaavalos.mastercake.screens.home.ProductsItem
import com.angelaavalos.mastercake.screens.home.models.Product
import com.angelaavalos.mastercake.screens.home.views.CategoriesItem


@Composable
fun HomeView(homeViewModel: HomeViewModel, navController: NavController) {
    val selectedProduct = remember { mutableStateOf(null as Product?) }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.weight(1f)  // Occupy most of the space
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
                        ProductsItem(product) {
                            selectedProduct.value = product
                        }
                    }
                }
            }
        }

        selectedProduct.value?.let { product ->
            ProductDescriptionDialog(product, onDismiss = { selectedProduct.value = null })
        }

        BottomNavBar() // This should now appear at the bottom
    }
}


@Composable
fun ProductDescriptionDialog(product: Product, onDismiss: () -> Unit) {
    val navController = rememberNavController()
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
@Preview
fun HomeViewPreview(){

    val navController = rememberNavController()

    HomeView(homeViewModel = HomeViewModel(), navController = navController)
    BottomNavBar()

}



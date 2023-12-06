package com.angelaavalos.mastercake.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.angelaavalos.mastercake.navigation.components.BottomNavBar
import com.angelaavalos.mastercake.screens.home.viewmodel.HomeViewModel
import com.angelaavalos.mastercake.screens.home.ProductsItem
import com.angelaavalos.mastercake.screens.home.models.Product
import com.angelaavalos.mastercake.screens.home.views.CategoriesItem
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.screens.utils.DropDownMenuSize
import com.angelaavalos.mastercake.security.TokenManager
import androidx.compose.ui.text.style.TextAlign


@Composable
fun HomeView(homeViewModel: HomeViewModel, navController: NavController) {

    val products by homeViewModel.products.observeAsState(emptyList())
    val categories by homeViewModel.categories.observeAsState(emptyList())
    val context = LocalContext.current

    val allProducts by homeViewModel.products.observeAsState(emptyList())
    val selectedCategoryProducts by homeViewModel.selectedCategoryProducts.observeAsState(emptyList())

    val productsToDisplay = if (selectedCategoryProducts.isNotEmpty()) selectedCategoryProducts else allProducts

    LaunchedEffect(Unit){
        val jwt = TokenManager.getToken(context)
        if(!jwt.isNullOrBlank()){
            homeViewModel.fetchProducts(jwt)
            homeViewModel.fetchCategories(jwt)
        }else{

        }

    }

    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(id = R.string.Home)) }) },
        content = { it
            val selectedProduct = remember { mutableStateOf(null as Product?) }

            Column(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier.weight(1f)  // Occupy most of the space
                ) {
                    item {
                        LazyRow(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(categories) { category ->
                                CategoriesItem(category = category, url = category.image){ categoryId ->
                                    homeViewModel.fetchProductsByCategory(categoryId)
                                }
                            }
                        }
                    }
                    items(productsToDisplay.chunked(2), key = { pair ->
                        // Combine the IDs of the products in the pair to create a unique key
                        pair.joinToString(separator = "-") { it._id }
                    }) { productPair ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            productPair.forEach { product ->
                                ProductsItem(product = product, onProductClick = {
                                    selectedProduct.value = product
                                }, url = product.image)
                            }
                        }
                    }

                }

               /* Button(onClick = { homeViewModel.refreshAllProducts() }) {
                    Text("Show All Products")
                }*/

                selectedProduct.value?.let { product ->
                    ProductDescriptionDialog(product, onDismiss = { selectedProduct.value = null }, url = product.image)
                }
                BottomNavBar(navController = navController) // This should now appear at the bottom
            }
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}

@Composable
fun ProductDescriptionDialog(product: Product, onDismiss: () -> Unit, url: String) {
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
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                val image = rememberImagePainter(
                    data = url,
                    builder = {
                        crossfade(true)
                        error(R.drawable.logobueno) // Imagen de error
                        placeholder(R.drawable.ic_launcher_background) // Imagen de carga
                    }
                )
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp) // Adjust the height of the image
                        .clip(shape = MaterialTheme.shapes.medium)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = product.product,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = product.price.toString() + "MXN",
                        style = MaterialTheme.typography.h6
                    )
                }

                Text(
                    text = product.description,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    textAlign = TextAlign.Center
                )

                DropDownMenuSize()

                // Add more elements below the description as needed.
            }
        }
    }
}



@Composable
@Preview
fun HomeViewPreview(){

    val navController = rememberNavController()

    HomeView(homeViewModel = HomeViewModel(), navController = navController)
    BottomNavBar(navController = navController)

}



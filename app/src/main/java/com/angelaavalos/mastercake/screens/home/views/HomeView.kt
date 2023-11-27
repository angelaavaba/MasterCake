package com.angelaavalos.mastercake.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import androidx.compose.material.Text as Text1


@Composable
fun HomeView(homeViewModel: HomeViewModel, navController: NavController) {

   val products by homeViewModel.products.observeAsState(emptyList())
    val context = LocalContext.current

    LaunchedEffect(Unit){
        val jwt = TokenManager.getToken(context)
        if(!jwt.isNullOrBlank()){
            homeViewModel.fetchProducts(jwt)
        }else{

        }

    }

    Scaffold(
        topBar = { TopAppBar(title = { Text1(stringResource(id = R.string.Home)) }) },
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
                            items(homeViewModel.categories) { category ->
                                CategoriesItem(category)
                            }
                        }
                    }
                    items(products.chunked(2)) {productPair ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            productPair.forEach { product ->
                                // Pass the product image URL to ProductsItem
                                ProductsItem(product = product, onProductClick = {
                                    selectedProduct.value = product
                                }, url = product.image)
                            }
                        }
                    }
                }

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
                val image = rememberImagePainter(url)
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                        Text1(
                            text = product.name,
                            style = MaterialTheme.typography.h5,
                        )
                    Text1(
                        text = product.price.toString() + "MXN",
                        style = MaterialTheme.typography.h6
                    )
                    }


                Text1(
                    text = product.description,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                DropDownMenuSize()

                // Puedes agregar más elementos debajo de la descripción según sea necesario.
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



package com.angelaavalos.mastercake.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.screens.home.models.Product
import com.angelaavalos.mastercake.screens.home.viewmodel.HomeViewModel

@Composable
fun ProductsItem(product: Product, onProductClick: ()->Unit) {
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

@Preview
@Composable
fun PreviewProductItem(){
    ProductsItem(product = Product(R.drawable.redvelvet,"Bosque",252.00,"hola angela")) {

    }
}
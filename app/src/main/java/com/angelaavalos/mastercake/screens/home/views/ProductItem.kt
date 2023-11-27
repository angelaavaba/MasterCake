package com.angelaavalos.mastercake.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.angelaavalos.mastercake.screens.home.models.Product
import com.angelaavalos.mastercake.ui.theme.MASTERCAKETheme

@Composable
fun ProductsItem(product: Product, onProductClick: () -> Unit, url: String) {

    MASTERCAKETheme() {
        Card(
            modifier = Modifier
                .width(180.dp)
                .clickable { onProductClick() }
                .border(
                    1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                val image = rememberImagePainter(url)
                Image(
                    painter = image,
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

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = product.price.toString() + "MXN",
                    )

                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewProductItem(){

}
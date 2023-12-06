package com.angelaavalos.mastercake.screens.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.screens.home.models.Category
import com.angelaavalos.mastercake.ui.theme.MASTERCAKETheme

@Composable
fun CategoriesItem(category: Category, url: String, onClick: (String) -> Unit) {

    MASTERCAKETheme() {
        Card(
            modifier = Modifier
                .clickable{onClick(category._id)}
                .width(110.dp)
                .padding(8.dp)
                .border(
                    1.dp,
                    color = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(shape = MaterialTheme.shapes.medium)
                        .padding(4.dp) // Adjust padding for alignment
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
                            .fillMaxSize()
                            .align(Alignment.Center)
                    )
                }
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
}

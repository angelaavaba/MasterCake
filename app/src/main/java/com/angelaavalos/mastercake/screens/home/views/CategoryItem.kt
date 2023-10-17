package com.angelaavalos.mastercake.screens.home.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.angelaavalos.mastercake.screens.home.models.Categories
import com.angelaavalos.mastercake.ui.theme.MASTERCAKETheme

@Composable
fun CategoriesItem(category: Categories) {

    MASTERCAKETheme() {
        Card(
            modifier = Modifier
                .width(110.dp)
                .padding(8.dp)
                .border(1.dp, color = MaterialTheme.colors.primary, shape = RoundedCornerShape(20.dp))
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
}

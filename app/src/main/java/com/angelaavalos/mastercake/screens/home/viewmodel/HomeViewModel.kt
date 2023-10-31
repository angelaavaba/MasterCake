package com.angelaavalos.mastercake.screens.home.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.screens.home.models.Categories
import com.angelaavalos.mastercake.screens.home.models.Product

class HomeViewModel : ViewModel(){

    val products = listOf(
        Product(R.drawable.bosque,R.string.forest_cake, 525.00, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.chocolima, R.string.chocolate_cake, 600.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.vainillafresa, R.string.strawberry_vanilla_cake, 480.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.redvelvet, R.string.cake_red_velvet, 550.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.bosque, R.string.forest_cake, 525.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.chocolima, R.string.chocolate_cake, 600.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.vainillafresa, R.string.strawberry_vanilla_cake, 480.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.redvelvet, R.string.cake_red_velvet, 550.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),

    )

    val categories = listOf(
        Categories(Icons.Filled.Cake, R.string.cakes),
        Categories(Icons.Filled.Icecream,R.string.Cupcakes),
        Categories(Icons.Filled.Cookie,R.string.cookies),
        Categories(Icons.Filled.BakeryDining,R.string.breads),
        Categories(Icons.Filled.Icecream,R.string.desserts)



    )
}
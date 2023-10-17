package com.angelaavalos.mastercake.screens.home.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.screens.home.models.Product

class HomeViewModel : ViewModel(){


    data class Categories(val icon: ImageVector, val name: String)


    val products = listOf(
        Product(R.drawable.bosque, "Pastel del bosque", 525.00, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.chocolima, "Pastel chocolima", 600.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.vainillafresa, "Pastel vainilla fresa", 480.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.redvelvet, "Pastel red velvet", 550.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.bosque, "Pastel del bosque", 525.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.chocolima, "Pastel chocolima", 600.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.vainillafresa, "Pastel vainilla fresa", 480.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        Product(R.drawable.redvelvet, "Pastel red velvet", 550.00,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),

    )

    val categories = listOf(
        Categories(Icons.Filled.Cake, "Pasteles"),
        Categories(Icons.Filled.Icecream, "Cupcakes"),
        Categories(Icons.Filled.Cookie, "Galletas"),
        Categories(Icons.Filled.BakeryDining, "Panes"),
        Categories(Icons.Filled.Icecream,"Postres")


    )
}
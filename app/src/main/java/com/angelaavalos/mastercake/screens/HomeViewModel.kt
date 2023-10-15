package com.angelaavalos.mastercake.screens

import androidx.lifecycle.ViewModel
import com.angelaavalos.mastercake.R

class HomeViewModel : ViewModel(){

    data class Product(val image: Int, val name: String, val precio: Double)


    val products = listOf(
        Product(R.drawable.bosque, "Pastel del bosque", 525.00),
        Product(R.drawable.chocolima, "Pastel chocolima", 600.00),
        Product(R.drawable.vainillafresa, "Pastel vainilla fresa", 480.00),
        Product(R.drawable.redvelvet, "Pastel red velvet", 550.00),
        Product(R.drawable.bosque, "Pastel del bosque", 525.00),
        Product(R.drawable.chocolima, "Pastel chocolima", 600.00),
        Product(R.drawable.vainillafresa, "Pastel vainilla fresa", 480.00),
        Product(R.drawable.redvelvet, "Pastel red velvet", 550.00),

    )
}
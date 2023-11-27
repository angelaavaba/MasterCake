package com.angelaavalos.mastercake.screens.home.viewmodel


import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.screens.home.models.Categories
import com.angelaavalos.mastercake.screens.home.models.Product
import com.angelaavalos.mastercake.screens.home.network.ProductRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(){
    private lateinit var jwt:String

    private val repository: ProductRepository by lazy { ProductRepository(jwt) }

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    fun fetchProducts(userJwt: String){
        this.jwt = userJwt
        viewModelScope.launch {
            try{
                val cards = repository.getProducts()
                _products.value = cards
            }catch(e: Exception){
                Log.e("API_ERROR", "Token used: $jwt")
                e.printStackTrace()


            }
        }
    }

    val categories = listOf(
        Categories(Icons.Filled.Cake, R.string.cakes),
        Categories(Icons.Filled.Icecream,R.string.Cupcakes),
        Categories(Icons.Filled.Cookie,R.string.cookies),
        Categories(Icons.Filled.BakeryDining,R.string.breads),
        Categories(Icons.Filled.Icecream,R.string.desserts)



    )
}
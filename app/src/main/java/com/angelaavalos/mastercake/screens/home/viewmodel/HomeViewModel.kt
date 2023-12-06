package com.angelaavalos.mastercake.screens.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelaavalos.mastercake.screens.home.models.Category
import com.angelaavalos.mastercake.screens.home.models.Product
import com.angelaavalos.mastercake.screens.home.network.CategoryRepository
import com.angelaavalos.mastercake.screens.home.network.ProductRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(){
    private lateinit var jwt:String

    private val repositoryP: ProductRepository by lazy { ProductRepository(jwt) }

    private val repositoryC: CategoryRepository by lazy { CategoryRepository(jwt) }

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> = _categories

    private val _selectedCategoryProducts = MutableLiveData<List<Product>>()
    val selectedCategoryProducts: LiveData<List<Product>> = _selectedCategoryProducts

    fun fetchProducts(userJwt: String){
        this.jwt = userJwt
        viewModelScope.launch {
            try{
                val products = repositoryP.getProducts()
                _products.value = products
            }catch(e: Exception){
                Log.e("API_ERROR", "Token used: $jwt")
                e.printStackTrace()
            }
        }
    }

    fun fetchCategories(userJwt: String){
        this.jwt = userJwt
        viewModelScope.launch {
            try{
                val categories = repositoryC.getCategories()
                _categories.value = categories
            }catch(e: Exception){
                Log.e("API_ERROR", "Token used: $jwt")
                e.printStackTrace()
            }
        }
    }

    fun fetchProductsByCategory(categoryId: String) {
        Log.d("HomeViewModel", "Fetching products for category: $categoryId")
        viewModelScope.launch {
            try {
                val products = repositoryP.getProductsByCategory(categoryId)
                _selectedCategoryProducts.value = products
            } catch (e: Exception) {
                Log.e("API_ERROR", "Error fetching products by category: $jwt")
                e.printStackTrace()
            }
        }
    }

    fun refreshAllProducts(){
        if(this::jwt.isInitialized){
            fetchProducts(jwt)
        }
    }

}
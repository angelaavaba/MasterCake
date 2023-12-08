package com.angelaavalos.mastercake.screens.favorites.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelaavalos.mastercake.screens.favorites.models.FavoriteModel
import com.angelaavalos.mastercake.screens.favorites.network.FavoriteRepository
import com.angelaavalos.mastercake.screens.utils.PreferenceManager
import kotlinx.coroutines.launch

class FavoriteViewModel(context: Context) : ViewModel() {

    private lateinit var jwt:String
    private val repository: FavoriteRepository by lazy { FavoriteRepository(jwt) }

    private val _userFavorites = MutableLiveData<List<FavoriteModel>>()
    val userFavorites: LiveData<List<FavoriteModel>> = _userFavorites

    private val preferenceManager = PreferenceManager(context)

    fun fetchUserFavorites(){
        val userId = preferenceManager.getStringData("userId", "") ?: return
        viewModelScope.launch {
            try{
                val favorites = repository.getUserFavorites(userId)
                _userFavorites.value = favorites
            } catch (e: Exception){
                Log.e("API_ERROR", "Error fetching favorites: $userId")
                e.printStackTrace()
            }
        }

    }

}



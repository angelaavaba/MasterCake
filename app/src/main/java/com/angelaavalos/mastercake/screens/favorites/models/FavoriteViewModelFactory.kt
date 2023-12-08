package com.angelaavalos.mastercake.screens.favorites.models

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.angelaavalos.mastercake.screens.favorites.viewmodel.FavoriteViewModel

class FavoriteViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

package com.angelaavalos.mastercake.screens.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelaavalos.mastercake.screens.register.model.RegisterDataBody
import com.angelaavalos.mastercake.screens.register.model.RegisterModel
import kotlinx.coroutines.launch

class RegisterViewModel() : ViewModel() {
    private val repository = RegisterRepository()

    private val _registerResponse = MutableLiveData<RegisterModel>()
    val registerResponse: LiveData<RegisterModel> = _registerResponse

    fun doRegister(registerData: RegisterDataBody){
        viewModelScope.launch {
            try {
                val registerResponse = repository.doRegister(registerData)
                _registerResponse.value = registerResponse
            }catch (e: Exception){
                //Handle error
                Log.d("RegisterViewModel","Error: ${e.message}")
            }
        }
    }





}
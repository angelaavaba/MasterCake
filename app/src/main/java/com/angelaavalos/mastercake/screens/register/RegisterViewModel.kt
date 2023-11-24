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
    private val _isRegisterSuccessful = MutableLiveData<Boolean>()
    val isRegisterSuccessful: LiveData<Boolean> = _isRegisterSuccessful

    private val _registerResponse = MutableLiveData<RegisterModel>()
    val registerResponse: LiveData<RegisterModel> = _registerResponse
    private val _registerAttempted = MutableLiveData<Boolean>()
    val registerAttempted: LiveData<Boolean> = _registerAttempted

    fun doRegister(registerData: RegisterDataBody){
        viewModelScope.launch {
            _registerAttempted.value = true

            try {
                val registerResponse = repository.doRegister(registerData)
                _registerResponse.value = registerResponse
                if(registerResponse.message == "Registro exitoso"){
                    _isRegisterSuccessful.value = true
                }else{
                    _isRegisterSuccessful.value = false
                }
            }catch (e: Exception){
                //Handle error
                Log.d("RegisterViewModel","Error: ${e.message}")
                _isRegisterSuccessful.value = false
            }
        }
    }





}
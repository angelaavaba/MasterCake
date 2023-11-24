package com.angelaavalos.mastercake.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelaavalos.mastercake.screens.login.model.LoginDataBody
import com.angelaavalos.mastercake.screens.login.model.LoginModel
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {
    private val repository = LoginRepository()
    private val _isLoginSuccessful = MutableLiveData<Boolean>()
    val isLoginSuccessful: LiveData<Boolean> = _isLoginSuccessful

    private val _loginResponse = MutableLiveData<LoginModel>()
    val loginResponse: LiveData<LoginModel> = _loginResponse
    private val _loginAttempted = MutableLiveData<Boolean>()
    val loginAttempted: LiveData<Boolean> = _loginAttempted

    fun doLogin(loginData: LoginDataBody) {
        viewModelScope.launch {
            _loginAttempted.value = true

            try {
                val loginResponse = repository.doLogin(loginData)
                _loginResponse.value = loginResponse
                if (loginResponse.message == "Login exitoso"){
                    _isLoginSuccessful.value = true
                }else{
                    _isLoginSuccessful.value = false
                }
            } catch (e: Exception) {
                // Handle error
                Log.d("LoginViewModel", "Error: ${e.message}")
                _isLoginSuccessful.value = false

            }
        }
    }
}
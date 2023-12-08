package com.angelaavalos.mastercake.screens.login

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelaavalos.mastercake.screens.login.model.LoginDataBody
import com.angelaavalos.mastercake.screens.login.model.LoginModel
import com.angelaavalos.mastercake.screens.user.models.UserResponse
import com.angelaavalos.mastercake.screens.user.network.UserRepository
import com.angelaavalos.mastercake.screens.utils.PreferenceManager
import com.angelaavalos.mastercake.security.TokenManager
import kotlinx.coroutines.launch


class LoginViewModel() : ViewModel() {
    private val repository = LoginRepository()
    private val _isLoginSuccessful = MutableLiveData<Boolean>()
    val isLoginSuccessful: LiveData<Boolean> = _isLoginSuccessful

    private val _loginResponse = MutableLiveData<LoginModel>()
    val loginResponse: LiveData<LoginModel> = _loginResponse
    private val _loginAttempted = MutableLiveData<Boolean>()
    val loginAttempted: LiveData<Boolean> = _loginAttempted

    private val userRepository = UserRepository()

    private val _userResponse = MutableLiveData<UserResponse>()
    val userResponse: LiveData<UserResponse> = _userResponse

    private val _loggedInUsername = MutableLiveData<String>()
    val loggedInUsername: LiveData<String> = _loggedInUsername




    fun doLogin(loginData: LoginDataBody, context: Context) {


        viewModelScope.launch {
            _loginAttempted.value = true

            try {
                val loginResponse = repository.doLogin(loginData)
                _loginResponse.value = loginResponse
                if (loginResponse.message == "Login exitoso" && loginResponse.jwt != null){
                    TokenManager.saveToken(context, loginResponse.jwt)
                    _isLoginSuccessful.value = true
                    saveLoggedInUsername(loginData.usrn)

                }else{
                    _isLoginSuccessful.value = false
                }
            } catch (e: Exception) {
                Log.e("LoginViewModel", "Error in login process", e)
                _isLoginSuccessful.value = false
            }
        }
    }

    private val _userId = MutableLiveData<String>()
    val userId: LiveData<String> = _userId

    fun getUser(username: String, preferenceManager: PreferenceManager) {
        viewModelScope.launch {
            try {
                val userResponse = userRepository.getUser(username)
                if (userResponse.obj != null) {
                    _userResponse.value = userResponse
                    val userId = userResponse.obj.id // Saved userId
                    _userId.value = userId
                    Log.d("LoginViewModel", "Fetched userId: $userId")

                    // Save userId in SharedPreferences
                    preferenceManager.saveStringData("userId", userId)
                } else {
                    Log.e("LoginViewModel", "User object is null")
                }
            } catch (e: Exception) {
                Log.e("LoginViewModel", "Error fetching user data", e)
            }
        }
    }



    fun saveLoggedInUsername(username: String) {
        _loggedInUsername.value = username
    }

}
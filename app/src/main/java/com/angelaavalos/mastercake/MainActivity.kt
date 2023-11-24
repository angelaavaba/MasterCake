@file:OptIn(ExperimentalPagerApi::class)

package com.angelaavalos.mastercake

import  android.annotation.SuppressLint

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import com.google.accompanist.pager.ExperimentalPagerApi
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.navigation.NavigationHost
import com.angelaavalos.mastercake.navigation.components.BottomNavBar
import com.google.android.gms.auth.api.Auth
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import com.angelaavalos.mastercake.screens.loginregister.AuthView


class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalPagerApi::class)
    private var canAuthenticate = false
    private lateinit var promptInfo: BiometricPrompt.PromptInfo
    private lateinit var biometricPrompt: BiometricPrompt
    var isAuthenticated = mutableStateOf(false)

    @SuppressLint("UnsafeOptInUsageError")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpAuth()

        setContent {
            val navController = rememberNavController()

            Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                  NavigationHost(navController)
             //   AuthView(isAuthenticated, onAuthenticated = ::handleAuthenticationResult)

            }


        }
    }
    private fun setUpAuth() {
        val biometricManager = BiometricManager.from(this)
        if (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK or BiometricManager.Authenticators.DEVICE_CREDENTIAL) == BiometricManager.BIOMETRIC_SUCCESS) {
            Log.d("MainActivity", "Puede autenticar")
            canAuthenticate = true
            promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Autenticación biométrica")
                .setSubtitle("Inicia sesión usando tu huella digital")
                .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_WEAK or BiometricManager.Authenticators.DEVICE_CREDENTIAL)
                .build()
            biometricPrompt = BiometricPrompt(
                this,
                ContextCompat.getMainExecutor(this),
                object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        super.onAuthenticationError(errorCode, errString)
                        Log.d("MainActivity", "onAuthenticationError: $errString ($errorCode)")

                        // Manejar error
                    }

                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)
                        Log.d("MainActivity", "onAuthenticationSucceeded")

                        // Autenticación exitosa
                        handleAuthenticationResult(true)
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        // Autenticación fallida
                        Log.d("MainActivity", "onAuthenticationFailed")
                        handleAuthenticationResult(false)
                    }
                })
        } else {
            Log.d("MainActivity", "No puede autenticar")
            // Manejar el caso donde no se puede autenticar
        }
    }

    private fun handleAuthenticationResult(result: Boolean) {
        Log.d("MainActivity", "aquiii")

        isAuthenticated.value = result  // Actualiza el estado observado

        //canAuthenticate = result
        // Aquí puedes manejar el resultado de la autenticación
        // Por ejemplo, puedes cambiar el estado de la UI o navegar a otra pantalla
    }


    fun authenticate(onAuthenticated: (Boolean) -> Unit) {
        if (canAuthenticate) {
            Log.d("MainActivity", "Intentando autenticar")
            biometricPrompt.authenticate(promptInfo)
        } else {
            // Manejar el caso donde no se puede autenticar
            Log.d("MainActivity", "No se puede autenticar")
            onAuthenticated(false)
        }
    }



}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(title = { Text("MASTER CAKE") }) },
        content = { it
            NavigationHost(navController = navController)
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}


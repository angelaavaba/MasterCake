package com.angelaavalos.mastercake.screens.login

import android.content.Context
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import com.angelaavalos.mastercake.ui.theme.MASTERCAKETheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.navigation.NavRoutes
import com.angelaavalos.mastercake.screens.login.model.LoginDataBody
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlin.coroutines.coroutineContext


@Composable
fun LoginView(navController: NavController, viewModel: LoginViewModel) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isLoginSuccessful by viewModel.isLoginSuccessful.observeAsState()
    var showErrorDialog by remember { mutableStateOf(false) }
    val loginAttempted by viewModel.loginAttempted.observeAsState()

    LaunchedEffect(isLoginSuccessful) {
        if (loginAttempted == true) {
            if (isLoginSuccessful == true) {
                showErrorDialog = false
                navController.navigate(NavRoutes.Home.route) {
                    popUpTo(NavRoutes.Home.route) { inclusive = true }
                }
            } else {
                Log.d("error", "error")
                showErrorDialog = true
            }
        } else {
            showErrorDialog = false
        }
    }




    Column {
        if (showErrorDialog) {
            AlertDialog(
                onDismissRequest = { showErrorDialog = false },
                title = { Text("Error") },
                text = { Text("Usuario incorrecto") },
                confirmButton = {
                    Button(
                        onClick = { showErrorDialog = false }
                    ) {
                        Text("Aceptar")
                    }
                }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.secondary)

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .align(Alignment.TopCenter)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
                    .padding(top = 25.dp)
                    .align(Alignment.BottomEnd),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                border = BorderStroke(1.dp, Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(30.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = stringResource(id = R.string.Text_LogIn),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    )

                    Text(
                        text = stringResource(id = R.string.Text_Email),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    MASTERCAKETheme() {
                        TextField(
                            value = username,
                            onValueChange = { username = it },
                            label = { Text(text = "username") },
                            textStyle = TextStyle(color = Color.White),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 30.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = MaterialTheme.colors.secondaryVariant)

                        )
                    }
                    Text(
                        text = stringResource(id = R.string.Text_Password),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    MASTERCAKETheme {
                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text(text = "*******") },
                            visualTransformation = PasswordVisualTransformation(),
                            textStyle = TextStyle(color = Color.White),
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = MaterialTheme.colors.secondaryVariant)

                        )
                    }
                    val context = LocalContext.current
                    Button(
                        onClick = {// navController.navigate(NavRoutes.Home.route)

                            viewModel.doLogin(
                                LoginDataBody(usrn = username, password = password),
                                context = context
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)


                    ) {
                        Text(text = stringResource(id = R.string.button_LogIn2))


                    }


                }

            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun LogInPreview() {
    LoginView(navController = rememberNavController(), viewModel = LoginViewModel())
}
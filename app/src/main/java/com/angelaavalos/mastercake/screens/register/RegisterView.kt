package com.angelaavalos.mastercake.screens.register

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angelaavalos.mastercake.R
import com.angelaavalos.mastercake.ui.theme.MASTERCAKETheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.angelaavalos.mastercake.navigation.NavRoutes
import com.angelaavalos.mastercake.screens.register.model.RegisterDataBody
import com.angelaavalos.mastercake.screens.utils.CalendarView
import com.angelaavalos.mastercake.screens.utils.DropDownMenuGender

@Composable
fun RegisterView(navController: NavController, viewModel: RegisterViewModel) {

    var username by remember{ mutableStateOf("")}
    var password by remember{ mutableStateOf("")}
    var domicilio by remember{ mutableStateOf("")}
    var sexo by remember{ mutableStateOf("Masculino")}
    val isRegisterSuccessful by viewModel.isRegisterSuccessful.observeAsState()
    var showErrorDialog by remember { mutableStateOf(false) }
    val loginAttempted by viewModel.registerAttempted.observeAsState()


    LaunchedEffect(isRegisterSuccessful) {
        if (loginAttempted == true) {
            if (isRegisterSuccessful == true) {
                showErrorDialog = false
                navController.navigate(NavRoutes.LoginView.route) {
                    popUpTo(NavRoutes.LoginView.route) { inclusive = true }
                }
            } else {
                Log.d("error", "error")
                showErrorDialog = true
            }
        } else {
            showErrorDialog = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary)
    ) {
        if (showErrorDialog) {
            AlertDialog(
                onDismissRequest = { showErrorDialog = false },
                title = { Text("Error") },
                text = { Text("Datos faltantes") },
                confirmButton = {
                    Button(
                        onClick = { showErrorDialog = false }
                    ) {
                        Text("Aceptar")
                    }
                }
            )
        }
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .align(Alignment.TopCenter)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.83f)
                .padding(top = 10.dp)
                .align(Alignment.BottomEnd),
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            border = BorderStroke(1.dp, Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 5.dp, end = 30.dp, start = 30.dp, bottom = 5.dp ),
                verticalArrangement = Arrangement.SpaceAround
            ) {

                Text(
                    text = stringResource(id = R.string.Text_register),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Text(
                    text = stringResource(id = R.string.Text_Email2),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                MASTERCAKETheme() {
                    TextField(
                        value = username,
                        onValueChange = {username = it},
                        label = { Text(text = "maquiavelo@gmail.com") },
                        textStyle = TextStyle(color = Color.White),
                        modifier = Modifier
                            .fillMaxWidth(),
                        //.padding(bottom = 20.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = MaterialTheme.colors.secondaryVariant)

                    )
                }
                Text(
                    text = stringResource(id = R.string.Text_Password2),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                MASTERCAKETheme {
                    TextField(
                        value = password,
                        onValueChange = {password = it},
                        label = { Text(text = "**********") },
                        visualTransformation = PasswordVisualTransformation(),
                        textStyle = TextStyle(color = Color.White),
                        modifier = Modifier
                            .fillMaxWidth(),
                        //.padding(bottom = 20.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = MaterialTheme.colors.secondaryVariant)

                    )
                    Text(
                        text = stringResource(id = R.string.Text_address),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    TextField(
                        value = domicilio,
                        onValueChange = {domicilio = it},
                        label = { Text(text = stringResource(id = R.string.Text_address2)) },
                        textStyle = TextStyle(color = Color.White),
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = MaterialTheme.colors.secondaryVariant)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.Text_gender),
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        DropDownMenuGender()
                    }
                   /* Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                    ) {
                        Text(
                            text = stringResource(id = R.string.Text_birthdate),
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        CalendarView()
                    }*/

                }
                    Button(
                        onClick = { //navController.navigate(route = "homeroute")
                            viewModel.doRegister(
                                RegisterDataBody(
                                    usrn = username,
                                    password = password,
                                    domicilio = domicilio,
                                    sexo = sexo
                                )
                            )},
                        modifier = Modifier
                            .fillMaxWidth(

                            )
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)


                    ) {
                        Text(text = stringResource(id = R.string.button_register2))
                    }




            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3(){

    val navController = rememberNavController()

    // Aquí proporciona el navController a RegisterView
    RegisterView(navController = navController, viewModel = RegisterViewModel())

}
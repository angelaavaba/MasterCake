package com.angelaavalos.mastercake.screens.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize
import com.angelaavalos.mastercake.ui.theme.MASTERCAKETheme
import com.angelaavalos.mastercake.R

@SuppressLint("SuspiciousIndentation")
@Composable
fun DropDownMenuSize(){

    // Declaring a boolean value to store
    // the expanded state of the Text Field
    var mExpanded by remember { mutableStateOf(false) }

    // Create a list of cities
    val gender = listOf("Large", "Medium", "Small")

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    // Create an Outlined Text Field
    // with icon and not expanded
    MASTERCAKETheme() {
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = MaterialTheme.colors.primary),
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = { Text(stringResource(id = R.string.size)) },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )
    }
    // Create a drop-down menu with list of cities,
    // when clicked, set the Text Field text as the city selected
    DropdownMenu(
        expanded = mExpanded,
        onDismissRequest = { mExpanded = false },
        modifier = Modifier
            .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
    ) {
        gender.forEach { label ->
            DropdownMenuItem(onClick = {
                mSelectedText = label
                mExpanded = false
            }) {
                Text(text = label)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview5(){
    DropDownMenuSize()
}

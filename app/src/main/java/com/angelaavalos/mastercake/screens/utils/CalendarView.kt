package com.angelaavalos.mastercake.screens.utils

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.*
import com.angelaavalos.mastercake.R


@Composable
fun CalendarView(){

    val mContext = LocalContext.current

    val mYear: Int
    val mMonth: Int
    val mDay: Int

    val mCalendar = Calendar.getInstance()

    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    val mDate = remember { mutableStateOf("") }

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
        }, mYear, mMonth, mDay
    )

    Button(
        onClick = { mDatePickerDialog.show() },
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondaryVariant),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text = if (mDate.value.isNotBlank()) mDate.value else stringResource(id = R.string.Text_birthdate2))
    }




}


@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    CalendarView()
}
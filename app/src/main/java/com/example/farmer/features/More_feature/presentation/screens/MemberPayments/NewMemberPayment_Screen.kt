package com.example.farmer.features.More_feature.presentation.screens.MemberPayments

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.features.Common_features.DialogSearchPerson
import com.example.farmer.features.Common_features.HeaderWithoutManuIcon
import com.example.farmer.features.Common_features.KeyboardTypes
import com.example.farmer.features.Common_features.NonPrimitiveTextField
import com.example.farmer.features.Common_features.TextFieldOptionsRow
import com.example.farmer.navigation.otherNavigation.OtherRoutes
import com.example.farmer.ui.theme.BlueJC

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddNewMemberPaymentScreen(onBackClick:() -> Unit = {}){


    var code by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var other by remember { mutableStateOf("") }

val paymentTypeOptions = listOf<String>("Debit/Payment Paid","Credit/Payment Received")

    var selectedPaymentType by remember { mutableStateOf(paymentTypeOptions[0]) }

    Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp, bottom = 16.dp, start = 4.dp, end = 4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        HeaderWithoutManuIcon(
            title = "New Member Payment",
            backIcon = true,
            onBackClick = {onBackClick()},
            isFirstTrailingIcon = false,
            isDateAndMorningBar = false,
            isSecondMoreTrailingIcon = false,
        )
        NonPrimitiveTextField(label = "Code", value = code, onValueChange = {code = it}, keyboardType = KeyboardTypes.Number,)
        NonPrimitiveTextField(label = "Name", value = name, onValueChange = {name = it}, keyboardType = KeyboardTypes.Text)
        TextFieldOptionsRow(options = paymentTypeOptions, label = "Payment Type", selectedOption = selectedPaymentType, onSelectedOption = { selectedPaymentType = it} )
        NonPrimitiveTextField(label = "Amount", value = amount, onValueChange = { amount = it}, keyboardType = KeyboardTypes.Number)
        NonPrimitiveTextField(label = "Other", value = other, onValueChange = { other = it}, keyboardType = KeyboardTypes.Text, singleLine = false)
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = {}, modifier = Modifier.fillMaxWidth().padding(4.dp).background(color = BlueJC, shape = RoundedCornerShape(12.dp))) {
            Text(text = "Save", color = Color.White, fontWeight = FontWeight.Medium, fontSize = 18.sp,)
        }

    }

}
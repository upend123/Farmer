package com.example.farmer.features.More_feature.presentation.screens.Products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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
import com.example.farmer.features.Common_features.HeaderWithoutManuIcon
import com.example.farmer.features.Common_features.KeyboardTypes
import com.example.farmer.features.Common_features.NonPrimitiveTextField
import com.example.farmer.ui.theme.BlueJC


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddNewProductScreen(onBackClick: () -> Unit = {}){
var name by remember { mutableStateOf("") }
var price by remember { mutableStateOf("") }
var unit by remember { mutableStateOf("") }
var otherDetails by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp, bottom = 16.dp), horizontalAlignment = Alignment.CenterHorizontally){
        HeaderWithoutManuIcon(title = "New Product",backIcon = true, onBackClick = { onBackClick() },
            isFirstTrailingIcon = false, isSecondMoreTrailingIcon = false,
            isDateAndMorningBar = false)
        NonPrimitiveTextField(value = name, onValueChange = { name = it }, label = "Name", keyboardType = KeyboardTypes.Text)
        NonPrimitiveTextField(value = price, onValueChange = { price = it }, label = "Price", keyboardType = KeyboardTypes.Number)
        NonPrimitiveTextField(value = unit, onValueChange = { unit = it }, label = "Unit", keyboardType = KeyboardTypes.Text)
        NonPrimitiveTextField(value = otherDetails, onValueChange = { otherDetails = it }, label = "OtherDetails", keyboardType = KeyboardTypes.Text ,singleLine = false)
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = {}, modifier = Modifier.fillMaxWidth().padding(4.dp).background(color = if(name.isNotEmpty() && price.isNotEmpty() && unit.isNotEmpty() ) BlueJC else Color.LightGray, shape = RoundedCornerShape(12.dp))) {
            Text(text = "Save", color = Color.White, fontWeight = FontWeight.Medium, fontSize = 18.sp,)
        }
    }
}

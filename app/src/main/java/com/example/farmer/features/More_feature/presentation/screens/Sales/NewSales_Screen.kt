package com.example.farmer.features.More_feature.presentation.screens.Sales

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
import com.example.farmer.ui.theme.BlueJC

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewSalesScreen(onAddProduct: () -> Unit = {},
                   onBackClick:() -> Unit = {}){

    var code by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var qty by remember { mutableStateOf("0") }
    var rate by remember { mutableStateOf("0") }
    val qtyValue = qty.toDoubleOrNull() ?: 0.0
    val rateValue = rate.toDoubleOrNull() ?: 0.0
    val amount by remember(qty,rate) { derivedStateOf {
        String.format("%.1f",qtyValue * rateValue)
    } }

    var isSearchProduct by remember { mutableStateOf(false) }
    val customerList = listOf<Pair<String, String>>("1" to "Rahul dhanger","2" to "Jalmod bare","3" to "Kishan verma","4" to "Arun chouhan","5" to "Vishal badole", "6" to "Yuvraj karma","7" to "Aayush sen","8" to "Sudarshan sharma","9" to "Sumit prajapat","10" to "Abhisek Prajapat")
    Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp, bottom = 16.dp, start = 4.dp, end = 4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        HeaderWithoutManuIcon(
            title = "New Sales",
            backIcon = true,
            onBackClick = {onBackClick()},
            isFirstTrailingIcon = false,
            isDateAndMorningBar = false,
            isSecondMoreTrailingIcon = false,
        )
        NonPrimitiveTextField(label = "Code", value = code, onValueChange = {code = it}, keyboardType = KeyboardTypes.Number,)
        NonPrimitiveTextField(label = "Name", value = name, onValueChange = {name = it}, keyboardType = KeyboardTypes.Text)
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Row(modifier = Modifier.fillMaxWidth().padding(8.dp).weight(1f).clickable(onClick = {
                isSearchProduct = true
            }), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Product", fontWeight = FontWeight.Medium, fontSize = 18.sp, color = Color.DarkGray)
                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
            }
            IconButton(onClick = {
                onAddProduct()
            }, modifier = Modifier.padding(4.dp).border(width = 2.dp, color = Color.LightGray, shape = CircleShape)) {
                Icon(Icons.Default.Add, contentDescription = null)
            }

        }
        if(isSearchProduct){
            DialogSearchPerson(show = isSearchProduct, onDismiss = { isSearchProduct = false }, onSelected = { code = it.first
            name = it.second
          isSearchProduct = false
}, list = customerList)
        }
        Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.weight(1f)){
                NonPrimitiveTextField(label = "Qty", value = qty, onValueChange = {qty = it}, keyboardType = KeyboardTypes.Number)
            }
            Box(modifier = Modifier.weight(1f)){
                NonPrimitiveTextField(label = "Rate", value = rate, onValueChange = {rate = it}, keyboardType = KeyboardTypes.Number)
            }
            Box(modifier = Modifier.weight(1f)){
                NonPrimitiveTextField(label = "Amount", value = amount, onValueChange = {}, readOnly = true, keyboardType = KeyboardTypes.Number)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = {}, modifier = Modifier.fillMaxWidth().padding(4.dp).background(color = BlueJC, shape = RoundedCornerShape(12.dp))) {
            Text(text = "Save", color = Color.White, fontWeight = FontWeight.Medium, fontSize = 18.sp,)
        }
    }


}

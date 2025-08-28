package com.example.farmer.features.Customers_feature.presentation.screens.AddCustomer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.features.Common_features.HeaderWithoutManuIcon
import com.example.farmer.features.Common_features.TextFieldOptionsRow
import com.example.farmer.ui.theme.BlueJC

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddCustomerScreen(
    onBackClick: () -> Unit = {}
){
var name by remember { mutableStateOf("") }
var code by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var otherDetail by remember { mutableStateOf("") }
    var BuffaloMilkRate by remember { mutableStateOf("") }
    var typeOfMilkList = listOf<String>("Buffelo","Cow","Buffalo & Cow")
    var BuffaloMilkRateTypeList = listOf<String>("As per Rate Chart","As Liter Rate","As FAT Rate","Rate Chart - Penalty","Rate Chart - Bonus","Manual")

    var selectedTypeofMilk by remember { mutableStateOf(typeOfMilkList[0]) }
    var selectedBuffaloMilkRateType by remember { mutableStateOf(BuffaloMilkRateTypeList[0]) }
    var selectedCowMilkRateType by remember { mutableStateOf(BuffaloMilkRateTypeList[0]) }

    Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp, bottom = 16.dp)){
        HeaderWithoutManuIcon(
            title = "New Customer",backIcon = true, onBackClick = { onBackClick() }
        )
        TextFieldRow(title = code , onTextChange = { code = it }, label = "Code", keyboardOptions = "number")
        TextFieldRow(title = name , onTextChange = { name = it }, label = "Name")
     Row(modifier = Modifier) {
        Box(modifier = Modifier.weight(1f)){
            TextFieldRow(title = mobileNumber , onTextChange = { mobileNumber = it }, label = "Mobile Number", keyboardOptions = "number",)
        }
         Box(modifier = Modifier.weight(0.2f)){
             IconButton(onClick = {}) {
                 Icon(Icons.Default.Call, contentDescription = null, tint = Color.Gray)
             }
        }

     }
        TextFieldOptionsRow(options = typeOfMilkList, label = "Type of milk", selectedOption = selectedTypeofMilk, onSelectedOption = { selectedTypeofMilk = it})
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
Box(modifier = Modifier.weight(1.3f)){
    TextFieldOptionsRow(options = typeOfMilkList, label =  "Buffalo milk rate type", selectedOption = selectedBuffaloMilkRateType, onSelectedOption = { selectedBuffaloMilkRateType = it})
}
            Box(modifier = Modifier.weight(1f)){
                TextFieldRow(title = BuffaloMilkRate , onTextChange = { BuffaloMilkRate = it }, label = "Buffalo Milk rate", keyboardOptions = "number")

            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.weight(1.3f)){
                TextFieldOptionsRow(options = BuffaloMilkRateTypeList, label = "Cow milk rate type", selectedOption = selectedCowMilkRateType, onSelectedOption = { selectedCowMilkRateType = it})


            }
            Box(modifier = Modifier.weight(1f)){
                TextFieldRow(title = name , onTextChange = { name = it }, label = "Buffalo Milk rate", keyboardOptions = "number")
            }

        }
       TextFieldRow(title = otherDetail , onTextChange = { otherDetail = it }, label = "other details")
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = {}, modifier = Modifier.fillMaxWidth().padding(6.dp).background(BlueJC, shape = RoundedCornerShape(12.dp))) {
            Text(text = "Save", color = Color.White, fontWeight = FontWeight.Medium, fontSize = 16.sp)
        }
    }

}

@Composable
fun TextFieldRow(title : String,onTextChange: (String) -> Unit,label : String,keyboardOptions: String = "text"){
    TextField(
        value = title,
        onValueChange = {
            onTextChange(it)
        },
       label = {
           Text(text = "$label")
               },

        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.DarkGray,
            focusedIndicatorColor = BlueJC,
            focusedLabelColor = BlueJC,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),
        textStyle = TextStyle(fontSize = 18.sp),
        keyboardOptions = KeyboardOptions(keyboardType = if(keyboardOptions == "number") KeyboardType.Number else KeyboardType.Text),
    )
}

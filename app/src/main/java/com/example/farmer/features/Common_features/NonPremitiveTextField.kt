package com.example.farmer.features.Common_features

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.ui.theme.BlueJC

@Composable
fun NonPrimitiveTextField(value: String, onValueChange: (String) -> Unit, label: String, readOnly: Boolean = false, keyboardType: KeyboardTypes = KeyboardTypes.Text,singleLine : Boolean = true){


    TextField(

        value = value,
        onValueChange = {
              if(keyboardType.types == KeyboardTypes.Number.types &&  it.all {
                      it.isDigit()
                  }){
                  onValueChange(it)
              }
           else if (keyboardType.types == KeyboardTypes.Text.types){
                onValueChange(it)
            }


        },

        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = label,fontSize = 18.sp, fontWeight = FontWeight.Medium , modifier = Modifier.padding(6.dp))},
        placeholder = {
            Text(text = "Enter $label")
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType.types ),
        readOnly = readOnly,
        singleLine = singleLine,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.DarkGray,
            focusedIndicatorColor = BlueJC,
            focusedLabelColor = BlueJC,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),

        textStyle = TextStyle(fontSize = 18.sp,)

    )
}
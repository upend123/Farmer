package com.example.farmer.features.Common_features

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.ui.theme.BlueJC


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun prevTextFieldOptionsRow(){

    val options = listOf<String>("FAT Only","FAT + SNF","FAT + CLR")

    TextFieldOptionsRow(options = options,label = "Rate type", selectedOption = "FAT Only", onSelectedOption = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldOptionsRow(
    options: List<String>,
    label: String,
    selectedOption: String,
    onSelectedOption: (String) -> Unit
){

    var isManuExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = isManuExpanded,
        onExpandedChange = {
            isManuExpanded = !isManuExpanded
        }
    ){
        TextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
              .fillMaxWidth()
                .menuAnchor()
             ,

            label = {
                Text(
                    text = label,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(6.dp)
                )
            },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.DarkGray,
                focusedIndicatorColor = BlueJC,
                focusedLabelColor = BlueJC,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            textStyle = TextStyle(fontSize = 18.sp),
            trailingIcon = { Icon(Icons.Default.ArrowDropDown, contentDescription = null, modifier = Modifier.rotate(if(isManuExpanded) 180f else 0f)) },


        )
        ExposedDropdownMenu(
            expanded = isManuExpanded,
            onDismissRequest = { isManuExpanded = false },
            modifier = Modifier.background(Color.White).padding(horizontal = 16.dp)
        ) {
            options.forEachIndexed {
                index,option ->
                DropdownMenuItem(
                    text = {
                        Text(text = option, fontSize = 16.sp,
                        color = if(option == selectedOption) BlueJC else Color.Black
                            )
                    },
                    onClick = { onSelectedOption(option)
                   isManuExpanded = false},

                )

            }
        }
    }

}
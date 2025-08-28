package com.example.farmer.features.More_feature.presentation.screens.MilkSales

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.Common.Constants.FAT_RATE
import com.example.farmer.R
import com.example.farmer.features.Common_features.DialogSearchPerson
import com.example.farmer.features.Common_features.HeaderWithManu
import com.example.farmer.features.Common_features.UserInfo
import com.example.farmer.ui.theme.BlueJC



@Composable
fun AddNewMilkSalesScreen(
    onBackClick: () -> Unit,
    onAddClick: () -> Unit
){

    val collectionList = mutableListOf<com.example.farmer.features.Collections_feature.domain.model.Collection>(
        com.example.farmer.features.Collections_feature.domain.model.Collection(
            code = "1",
            name = "Harish",
            fat = 6.0,
            fatRate = FAT_RATE.toDouble(),
            milkQuantity = 5.0
        ),
        com.example.farmer.features.Collections_feature.domain.model.Collection(
            code = "2",
            name = "Raaavi",
            fat = 6.0,
            fatRate = FAT_RATE.toDouble(),
            milkQuantity = 7.0
        ),
        com.example.farmer.features.Collections_feature.domain.model.Collection(
            code = "3",
            name = "Aashish",
            fat = 7.0,
            fatRate = FAT_RATE.toDouble(),
            milkQuantity = 8.0
        ),
        com.example.farmer.features.Collections_feature.domain.model.Collection(
            code = "4",
            name = "kelash",
            fat = 5.0,
            fatRate = FAT_RATE.toDouble(),
            milkQuantity = 9.0
        )
    )
    var isUserInfoExpanded by remember { mutableStateOf(false) }

    var code by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var Liter by remember { mutableStateOf("") }
    var FAT by remember { mutableStateOf("") }

    var showPersonSearchDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val manuList = listOf<Pair<String,Int>>("Settings" to R.drawable.baseline_settings_24,
        "Sort: By Code" to R.drawable.baseline_sort_by_alpha_24,
        "Sort: By Time" to R.drawable.baseline_access_time_24,
        "Reconnect Printer" to R.drawable.baseline_print_24,)
    var isBuffaloSelected by remember { mutableStateOf(true) }

    var trailingIconCoordinates by remember { mutableStateOf<LayoutCoordinates?>(null) }

    val customerList = listOf<Pair<String, String>>("1" to "Rahul dhanger","2" to "Jalmod bare","3" to "Kishan verma","4" to "Arun chouhan","5" to "Vishal badole", "6" to "Yuvraj karma","7" to "Aayush sen","8" to "Sudarshan sharma","9" to "Sumit prajapat","10" to "Abhisek Prajapat")

    val fatRate = FAT_RATE.toDouble()
    val fatValue = FAT.toDoubleOrNull() ?: 0.0
    val literValue = Liter.toDoubleOrNull() ?: 0.0

    //calculate rate dynamically
    val calculateRate: String by remember(FAT) {
        derivedStateOf {
            String.format("%.1f", fatValue * fatRate)
        }
    }
    var rate by remember { mutableStateOf(calculateRate) }

    val calculateAmount by remember(FAT,Liter) {
        derivedStateOf {
            String.format("%.1f",fatValue * fatRate * literValue)

        }
    }
    var isMenuExpanded by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize().padding(top = 16.dp, bottom = 16.dp)){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            HeaderWithManu(
                title = "New Milk Sales",
                isFirstTrailingIcon = false,
                isMoreTrailingIcon = true,
                manuList = manuList,
                onBackClick = {
                    onBackClick()
                },
                onAddClick = {}
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // TextField: Code Input
                TextField(
                    value = code,
                    onValueChange = {
                        if (it.length <= 10 && it.all { char -> char.isDigit() }) {
                            code = it
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = {
                        Text("Code")
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.DarkGray,
                        focusedIndicatorColor = BlueJC,
                        focusedLabelColor = BlueJC,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    textStyle = TextStyle(fontSize = 18.sp),
                    trailingIcon = {
                        IconButton(onClick = {
                            if (code.isNotEmpty()) {
                                code = ""
                                name = ""
                                Liter = ""
                                FAT = ""
                            } else {
                                showPersonSearchDialog = true
                            }
                        }) {
                            Icon(
                                painter = painterResource(if (code.isNotEmpty()) R.drawable.baseline_clear_24 else R.drawable.baseline_person_search_24),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                )
                if (showPersonSearchDialog) {
                    DialogSearchPerson(
                        show = showPersonSearchDialog,
                        onDismiss = { showPersonSearchDialog = false },
                        onSelected = { customer ->
                            code = customer.first
                            name = customer.second
                            showPersonSearchDialog = false
                        },
                        list = customerList
                    )
                }

                // Toggle Buttons (Buffalo / Cow)
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .height(40.dp)

                ) {
                    TextButton(
                        onClick = { isBuffaloSelected = true },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .border(
                                0.7.dp,
                                Color.DarkGray,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .background(
                                if (isBuffaloSelected) Color.LightGray else Color.White,
                                shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp)
                            )
                    ) {
                        Text(
                            text = "Buffalo",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    TextButton(
                        onClick = { isBuffaloSelected = false },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .border(
                                0.7.dp,
                                Color.DarkGray,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .background(
                                if (isBuffaloSelected) Color.White else Color.LightGray,
                                shape = RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp)
                            )
                    ) {
                        Text(
                            text = "Cow",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )
                    }
                }

                // Date & Session Column
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "01/07",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Evening",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )

                }
            }
            TextField(
                value = name,
                onValueChange = {
                    name = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                singleLine = true,
                readOnly = true,
                label = { Text(text = "Name")},
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.DarkGray,
                    focusedIndicatorColor = BlueJC,
                    focusedLabelColor = BlueJC,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                textStyle = TextStyle(fontSize = 18.sp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = Liter,
                    onValueChange = {
                        if (it.all { char -> char.isDigit() }) {
                            Liter = it
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    label = {
                        Text(text = "Liter")
                    },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.DarkGray,
                        focusedIndicatorColor = BlueJC,
                        focusedLabelColor = BlueJC,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    textStyle = TextStyle(fontSize = 18.sp)
                )

                TextField(
                    value = rate,
                    onValueChange = {
                        if (it.all { char -> char.isDigit() }) {
                            rate = it
                        }
                    },
                    label = {
                        Text(text = "Rate")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.DarkGray,
                        focusedIndicatorColor = BlueJC,
                        focusedLabelColor = BlueJC,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    textStyle = TextStyle(fontSize = 18.sp)
                )
                TextField(
                    value = calculateAmount,
                    onValueChange = {},
                    label = {
                        Text(text = "Amount")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    readOnly = true,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.DarkGray,
                        focusedIndicatorColor = BlueJC,
                        focusedLabelColor = BlueJC,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    textStyle = TextStyle(fontSize = 18.sp)
                )
            }
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
              items(collectionList) { collection ->
                    UserInfo(isExpanded = isUserInfoExpanded, onClick = { isUserInfoExpanded = !isUserInfoExpanded}, collection = collection)
                }
            }
        }
        TextButton(onClick = {
            Toast.makeText(context,"Collection Saved",Toast.LENGTH_SHORT).show()
        },
            modifier = Modifier.fillMaxWidth().padding(6.dp).background(if(code.isNotBlank() && Liter.isNotBlank() && FAT.isNotBlank()) BlueJC else Color.LightGray, shape = RoundedCornerShape(12.dp)).align(Alignment.BottomCenter)) {
            Text(
                text = "Save",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }

    }

}
package com.example.farmer.features.More_feature.presentation.screens.DairyInformation


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import com.example.farmer.features.Common_features.HeaderWithManu

import com.example.farmer.features.Common_features.TextFieldOptionsRow
import com.example.farmer.ui.theme.BlueJC


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun prevDairyInformation(){
    DairyInformationScreen(onBackClick = {})
}

@Composable
fun DairyInformationScreen(
    onBackClick: () -> Unit
){
    val context = LocalContext.current
    var dairyName by remember { mutableStateOf("Jai Singaji") }
    var address by remember { mutableStateOf("Gram Jhirniya,block Maheshwar,Dist Khargon,Mp") }
    val rateTypeOptions = listOf<String>("FAT Only","FAT + SNF","FAT + CLR")
    val PaymentDurationOptions = listOf<String>("1 Date","10 Days (01-10,11-20,21 Morning/Evening)","15 Days (01-15,16 Morning/Evening)")

    var selectedRateType by remember { mutableStateOf(rateTypeOptions[0]) }
    var selectedPaymentDuration by remember { mutableStateOf(PaymentDurationOptions[0]) }


    var bonus by remember { mutableStateOf("0") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 16.dp // paddingValues.calculateTopPadding(),
                , bottom =  16.dp//paddingValues.calculateBottomPadding()
            )
    ) {
        HeaderWithManu(title = "Dairy Information", secondTrailingIcon = R.drawable.baseline_more_vert_24, onBackClick = {onBackClick()}, onAddClick = {},)
        Column(modifier = Modifier.fillMaxSize().background(Color.White), horizontalAlignment = Alignment.CenterHorizontally) {

            TextField(
value = dairyName,
                onValueChange = {
                    dairyName = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Dairy Name",fontSize = 11.sp, fontWeight = FontWeight.Medium , modifier = Modifier.padding(6.dp))},
                placeholder = {
                    Text(text = "Enter Dairy Name")
                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.DarkGray,
                    focusedIndicatorColor = BlueJC,
                    focusedLabelColor = BlueJC,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                textStyle = TextStyle(fontSize = 18.sp,)

            )
            TextField(
                value = address,
                onValueChange = {
                    address = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Address",fontSize = 11.sp, fontWeight = FontWeight.Medium , modifier = Modifier.padding(6.dp))},
                placeholder = {
                    Text(text = "Enter Address")
                },
                maxLines = 3,
                minLines = 2,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.DarkGray,
                    focusedIndicatorColor = BlueJC,
                    focusedLabelColor = BlueJC,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                textStyle = TextStyle(fontSize = 18.sp)

            )
            TextFieldOptionsRow(options = rateTypeOptions, label = "Rate type", selectedOption = selectedRateType, onSelectedOption = { selectedRateType = it})
            TextFieldOptionsRow(options =PaymentDurationOptions, label = "Payment duration",selectedOption = selectedPaymentDuration, onSelectedOption = { selectedPaymentDuration = it})

            TextField(
                value = bonus,
                onValueChange = {
                    if(it.all { it.isDigit() } && it.length <= 4 ){
                        bonus = it
                    }

                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Bonus per liter",fontSize = 11.sp, fontWeight = FontWeight.Medium , modifier = Modifier.padding(6.dp))},
                placeholder = {
                    Text(text = "Enter Bonus")
                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.DarkGray,
                    focusedIndicatorColor = BlueJC,
                    focusedLabelColor = BlueJC,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                textStyle = TextStyle(fontSize = 18.sp,)

            )
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier.fillMaxWidth().padding(10.dp), contentAlignment = Alignment.Center){
                TextButton(onClick = {

                    Toast.makeText(context,"Dairy Information Saved", Toast.LENGTH_SHORT).show()
                }, modifier = Modifier.fillMaxWidth().background(color = BlueJC, shape = RoundedCornerShape(12.dp))) {
                    Text(text = "Save", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Medium,)
                }
            }

        }
    }



}

/*
   value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource? = null,
    shape: Shape = TextFieldDefaults.shape,
    colors: TextFieldColors = TextFieldDefaults.colors()
 */
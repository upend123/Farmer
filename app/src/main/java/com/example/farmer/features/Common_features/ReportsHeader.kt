package com.example.farmer.features.Common_features

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import com.example.farmer.features.Collections_feature.presentation.screens.collections.datePickerDialog
import com.example.farmer.features.Collections_feature.presentation.screens.collections.morningDropdownButton
import com.example.farmer.ui.theme.BlueJC
import java.util.Calendar

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun prevReportsHeader(){
    ReportsHeader(
        title = "Collections",
        backIcon = true,
        isFirstTrailingIcon = true,
        firstTrailingIcon = R.drawable.baseline_engineering_24,
        isSecondMoreTrailingIcon = true,
        secondTrailingIcon = R.drawable.baseline_screen_share_24,
       dateDialog = true,
        morningDropDown = false,isDateAndMorningBar = true
        ,isCustomerOptions = true,
        isBothDropdownOptions = true,
        isFirstDropdownOptions = true, firstDropdownOptionsIcon = R.drawable.baseline_insert_page_break_24,
        isSecondDropdownOptions = true, secondDropdownOptionsIcon = R.drawable.baseline_sort_24,
        firstDropdownOptions =  listOf<String>("Paper Roll","A4"),
        secondDropdownOptions =  listOf<String>("By Cattle","By Members"),
        secondDateDialog = true,
onBackClick = {},
        onFirstTrailingIconClick = {},
        onSecondTrailingIconClick = {}
    )
}

@Composable
fun ReportsHeader(
    title: String = "",
    backIcon: Boolean = true,
    isFirstTrailingIcon: Boolean = false,
    @DrawableRes firstTrailingIcon: Int = R.drawable.baseline_add_24,
    isSecondMoreTrailingIcon: Boolean = false,
    secondTrailingIcon: Int = R.drawable.baseline_more_vert_24,
    isBothDropdownOptions: Boolean = false,
    isFirstDropdownOptions : Boolean = false,
    isSecondDropdownOptions : Boolean = false,
    firstDropdownOptionsIcon: Int? = null,
    secondDropdownOptionsIcon: Int? = null,
    firstDropdownOptions: List<String>? = listOf<String>("Paper Roll","A4"),
    secondDropdownOptions: List<String>? = listOf<String>("By Cattle","By Members"),
    isCustomerOptions: Boolean = false,
    customerDropdownOptions: List<String>? = listOf<String>("All Customers","1:Rohit","2:Mohit","3:Chaman","4:Raman","5:Karan","6:Ravan"),
    dateDialog: Boolean = true,
    secondDateDialog: Boolean = false,
    morningDropDown: Boolean = false,
    isDateAndMorningBar: Boolean = false,
      onBackClick: () -> Unit,
    onFirstTrailingIconClick: () -> Unit,
    onSecondTrailingIconClick: () -> Unit

){
    val context = LocalContext.current

    var morningUnitOptions = listOf("Morning", "Evening")
    var selectedMorningUnit by remember { mutableStateOf(morningUnitOptions[0]) }
    var isManuExpanded by remember { mutableStateOf(false) }

    var selectedDate by remember { mutableStateOf("${Calendar.getInstance().get(Calendar.DAY_OF_MONTH)}/"+
            "${Calendar.getInstance().get(Calendar.MONTH) + 1}/"+
            "${Calendar.getInstance().get(Calendar.YEAR)}") }

    val minDate = Calendar.getInstance().apply {
        set(2025,6-1,14) // 14 July 2025
    }
    val maxDate = Calendar.getInstance().apply {
        set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) ,
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) //Current Date
    }
//Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp, bottom = 16.dp)) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 4.dp),
    ) {
        if(backIcon){
            IconButton(
                onClick = { onBackClick()},
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "add",
                    modifier = Modifier
                )
            }
        }
        Text(
            textAlign = TextAlign.Center,
            text = title,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.Center)
        )
        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            if(isFirstTrailingIcon){
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        painter = painterResource(firstTrailingIcon),
                        contentDescription = "add",
                        modifier = Modifier,
                        tint = Color.DarkGray
                    )
                }
            }
            if(isSecondMoreTrailingIcon){
                IconButton(onClick = {}) {
                    Icon(painter = painterResource(secondTrailingIcon), contentDescription = "more", tint = Color.DarkGray)
                }
            }
        }

    }
    Divider(modifier = Modifier.fillMaxWidth(), thickness = 0.8.dp, color = Color.DarkGray)
if(isBothDropdownOptions){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
        if(isFirstDropdownOptions){
           Box(modifier = Modifier.weight(0.5f)){
               ReportsHeaderOptionsRow(options = firstDropdownOptions!!, icon = firstDropdownOptionsIcon)
           }
        }
        if(isSecondDropdownOptions){
           Box(modifier = Modifier.weight(0.5f)){
               ReportsHeaderOptionsRow(options = secondDropdownOptions!!, icon = secondDropdownOptionsIcon)
           }
        }
    }
    Divider(modifier = Modifier.fillMaxWidth(), thickness = 0.8.dp, color = Color.LightGray)
}
    if(isCustomerOptions){
        ReportsHeaderOptionsRow(options = customerDropdownOptions!!, icon = null)
    }
       if(isDateAndMorningBar){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if(dateDialog){ Column {

                TextButton(onClick = {
                    datePickerDialog(
                        context,
                        onSet = { pickedDate -> selectedDate = pickedDate },
                        minDate = minDate,
                        maxDate = maxDate
                    )
                }) {

                    Text(
                        text = selectedDate,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        painter = painterResource(R.drawable.baseline_date_range_24),
                        contentDescription = "dateSet",
                    )
                }


            }
            }
            if(secondDateDialog){ Column(){
                TextButton(onClick = {
                    datePickerDialog(
                        context,
                        onSet = { pickedDate -> selectedDate = pickedDate },
                        minDate = minDate,
                        maxDate = maxDate
                    )
                }) {

                    Text(
                        text = selectedDate,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        painter = painterResource(R.drawable.baseline_date_range_24),
                        contentDescription = "dateSet",
                    )
                }


            }
            }
            if (morningDropDown) {
                Column(
                    verticalArrangement = Arrangement.Center,
                ) {
                    morningDropdownButton(
                        label = selectedMorningUnit,
                        expanded = isManuExpanded,
                        onExpandChange = {
                            isManuExpanded = it
                        },
                        onOptionSelected = { unit ->
                            selectedMorningUnit = unit
                        }
                    )
                }
            }
            Column() {

                TextButton(onClick = {
                    Toast.makeText(context,"View Clicked", Toast.LENGTH_SHORT).show()
                }) {

                    Text(
                        text = "View",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Icon(
                        painter = painterResource(R.drawable.baseline_arrow_forward_24),
                        contentDescription = "dateSet",
                    )
                }


            }

        }
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color.DarkGray)
    }

//}


}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun prevReportsHeaderOptionsRow(){

    val options = listOf<String>("FAT Only","FAT + SNF","FAT + CLR")

    ReportsHeaderOptionsRow(options = options, icon = R.drawable.baseline_insert_page_break_24)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportsHeaderOptionsRow(
    options: List<String>,
    @DrawableRes icon : Int? = null
){
    var selectedOption by remember {mutableStateOf(options[0])}
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
            leadingIcon = {
              if(icon != null){
                  Icon(painter = painterResource(icon), contentDescription = null)
              }
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
                    onClick = { selectedOption = option
                        isManuExpanded = false},

                    )

            }
        }
    }

}
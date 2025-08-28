package com.example.farmer.features.Common_features

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
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import com.example.farmer.features.Collections_feature.presentation.screens.collections.datePickerDialog
import com.example.farmer.features.Collections_feature.presentation.screens.collections.morningDropdownButton
import java.util.Calendar

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun prevHeaderWithoutManuIcon
(){
    HeaderWithoutManuIcon(
        title = "Collections", backIcon = true,isFirstTrailingIcon = true, firstTrailingIcon = R.drawable.baseline_engineering_24, isSecondMoreTrailingIcon = true, dateDialog = true,
        morningDropDown = true,isDateAndMorningBar = true,secondTrailingIcon = R.drawable.baseline_screen_share_24, onSecondTrailingIconClick = {})
}

@Composable
fun HeaderWithoutManuIcon
(
    title: String = "",
    backIcon: Boolean = true,
    isFirstTrailingIcon: Boolean = false,
    @DrawableRes firstTrailingIcon: Int = R.drawable.baseline_add_24,
    isSecondMoreTrailingIcon: Boolean = false,
    dateDialog: Boolean = true,
    morningDropDown: Boolean = true,
    isDateAndMorningBar: Boolean = false,
    secondTrailingIcon: Int = R.drawable.baseline_more_vert_24,
    onTrailingIconPositioned: ((LayoutCoordinates) -> Unit)? = null,
    onBackClick: () -> Unit = {} ,
    onFirstTrailingIconClick: () -> Unit = {},
    onSecondTrailingIconClick: () -> Unit = {}
) {
    val context = LocalContext.current

    var morningUnitOptions = listOf("Morning", "Evening")
    var selectedMorningUnit by remember { mutableStateOf(morningUnitOptions[0]) }
    var isManuExpanded by remember { mutableStateOf(false) }

    var selectedDate by remember {
        mutableStateOf(
            "${Calendar.getInstance().get(Calendar.DAY_OF_MONTH)}/" +
                    "${Calendar.getInstance().get(Calendar.MONTH) + 1}/" +
                    "${Calendar.getInstance().get(Calendar.YEAR)}"
        )
    }

    val minDate = Calendar.getInstance().apply {
        set(2025, 6 - 1, 14) // 14 July 2025
    }
    val maxDate = Calendar.getInstance().apply {
        set(
            Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        ) //Current Date
    }

       // Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp, bottom = 16.dp)) {


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(horizontal = 4.dp),
            ) {
                if (backIcon) {
                    IconButton(
                        onClick = { onBackClick() },
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
                    fontSize = 24.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.align(Alignment.Center)
                )
                Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                    if (isFirstTrailingIcon) {
                        IconButton(
                            onClick = {
                               onFirstTrailingIconClick()
                            },
                        ) {
                            Icon(
                                painter = painterResource(firstTrailingIcon),
                                contentDescription = "add",

                                )
                        }
                    }
                    if (isSecondMoreTrailingIcon) {
                        IconButton(onClick = { onSecondTrailingIconClick() }, modifier = Modifier.then(
                            Modifier.onGloballyPositioned { coordinates ->
                                onTrailingIconPositioned?.invoke(coordinates)

                            }
                        )
                        ) {
                            Icon(
                                painter = painterResource(secondTrailingIcon),
                                contentDescription = "more"
                            )
                        }
                    }
                }

            }
            Divider(modifier = Modifier.fillMaxWidth(), thickness = 0.8.dp, color = Color.DarkGray)
            if (isDateAndMorningBar) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (dateDialog) {
                    Column {

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
                    Spacer(modifier = Modifier.weight(1f))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.End
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
            }
            Divider(modifier = Modifier.fillMaxWidth(), thickness = 0.8.dp, color = Color.Gray)
        }


    //}
}
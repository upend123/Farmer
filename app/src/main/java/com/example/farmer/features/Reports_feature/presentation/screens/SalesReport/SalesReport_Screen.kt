package com.example.farmer.features.Reports_feature.presentation.screens.SalesReport

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.farmer.R
import com.example.farmer.features.Common_features.BlankPage

import com.example.farmer.features.Common_features.ReportsHeader
import kotlin.String

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SalesReportScreen(onBackClick: () -> Unit = {} ){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 16.dp // paddingValues.calculateTopPadding(),
                , bottom =  16.dp//paddingValues.calculateBottomPadding()
            )
    ) {
        ReportsHeader(title = "Sales Report", isFirstTrailingIcon = true, isSecondMoreTrailingIcon = true, firstTrailingIcon = R.drawable.baseline_print_24, secondTrailingIcon = R.drawable.baseline_screen_share_24,
            onBackClick = { onBackClick() },
            isBothDropdownOptions = true,isFirstDropdownOptions = true, firstDropdownOptionsIcon = R.drawable.baseline_insert_page_break_24,
            isSecondDropdownOptions = true, secondDropdownOptionsIcon = R.drawable.baseline_sort_24,
            firstDropdownOptions =  listOf<String>("Paper Roll","A4"),
            secondDropdownOptions = listOf<String>("By Cattle","By Members"),
            dateDialog = true, backIcon = true, isDateAndMorningBar = true,
            morningDropDown = false,secondDateDialog = true,
            isCustomerOptions = true, customerDropdownOptions =  listOf<String>("All Customers","1:Rohit","2:Mohit","3:Chaman","4:Raman","5:Karan","6:Ravan"),
            onFirstTrailingIconClick = {},
            onSecondTrailingIconClick = {}
        )

        LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                BlankPage(title = "No Records", description = "Set the date and click 'View' TO access the report.")
            }
        }
    }



}

package com.example.farmer.features.More_feature.presentation.screens.MilkSales

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import com.example.farmer.features.Common_features.HeaderWithManu

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MilkSalesScreen(
    onBackClick: () -> Unit,
    onAddClick: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 16.dp // paddingValues.calculateTopPadding(),
                , bottom =  16.dp//paddingValues.calculateBottomPadding()
            )
    ) {
        HeaderWithManu(
            title = "Milk Sales",
            backIcon = true,
            isFirstTrailingIcon = true,
            firstTrailingIcon = R.drawable.baseline_add_24,
          isMoreTrailingIcon = true,
            isDateAndMorningBar = true,
            manuList = listOf<Pair<String, Int>>("Sort: By Code" to R.drawable.baseline_sort_by_alpha_24,"Sort: By Time" to R.drawable.baseline_access_time_24,"Reconnect Printer" to R.drawable.baseline_print_24),
          onBackClick = {
              onBackClick()
          },
            onAddClick = {
                onAddClick()
            },
            secondTrailingIcon = R.drawable.baseline_more_vert_24 )
        LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
item {
    Text(text = "No Records", fontWeight = FontWeight.Medium, fontSize = 18.sp, color = Color.DarkGray)
    Spacer(modifier = Modifier.height(4.dp))
    Text(text = "Press + to add new record", fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.DarkGray)

}
        }
    }



}

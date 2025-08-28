package com.example.farmer.features.Collections_feature.presentation.screens.absentCostomers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.farmer.features.Common_features.CustomerRow.CustomerRow
import com.example.farmer.features.Common_features.HeaderWithoutManuIcon
import com.example.farmer.features.Customers_feature.domain.model.Customer

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AbsentCustomersScreen(onBackClick: () -> Unit = {}){
    val customerList = mutableListOf<Customer>(Customer(code = "1", name = "Harish", number = "2543532556"),
        Customer(code = "2","Ramesh","32533563467"),
        Customer(code = "3","Suresh","77567364434"))
    var expandedIndex by  remember { mutableStateOf<Int?>(null) }

    Column (modifier = Modifier.fillMaxSize().padding(top = 16.dp, bottom = 16.dp)){
        HeaderWithoutManuIcon(
            title = "Absent Customers",
                onBackClick = {
                    onBackClick()
                }
        )
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
            Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Date",
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.padding(6.dp))
                Text(
                    text = "10/07",
                    fontSize = 16.sp,
                  fontWeight = FontWeight.Medium,

                )
            }
            Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Shift",
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.padding(6.dp))
                Text(
                    text = "Evening",
                    fontSize = 16.sp,
                  fontWeight = FontWeight.Medium,

                )
            }
            Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Total",
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.padding(6.dp))
                Text(
                    text = "2",
                    fontSize = 16.sp,
                  fontWeight = FontWeight.Medium,

                )
            }
        }
        Divider(modifier = Modifier.fillMaxWidth().height(0.8.dp), color = Color.Gray)
        LazyColumn {
            itemsIndexed(customerList) {
                index, customer ->
                CustomerRow( isExpanded = expandedIndex == index,
                    onClick = { expandedIndex = if(expandedIndex == index) null else index },
                    customer = customer)
            }
        }
    }
}
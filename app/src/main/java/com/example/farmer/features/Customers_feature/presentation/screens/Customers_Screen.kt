package com.example.farmer.features.Customers_feature.presentation.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import com.example.farmer.features.Common_features.CustomerRow.CustomerRow
import com.example.farmer.features.Common_features.SearchBar
import com.example.farmer.features.Customers_feature.domain.model.Customer

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PrevCustomersScreen(){
//    CustomersScreen(paddingValues = paddingValues, onAddCustomerClick = {}) {}
//}


@Composable
fun CustomersScreen(
    paddingValues: PaddingValues,
    onAddCustomerClick: () -> Unit,
    onBackClick: () -> Unit
){
            val customerList = mutableListOf<Customer>(Customer(code = "1", name = "Harish", number = "2543532556"),
                Customer(code = "2","Ramesh","32533563467"),
                Customer(code = "3","Suresh","77567364434"))

    var expandedIndex by  remember { mutableStateOf<Int?>(null) }
    var searchExpanded by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    val filteredList by remember(searchQuery) { derivedStateOf {
           if(searchQuery.isBlank()) customerList else customerList.filter { it.code.contains(searchQuery.trim(),ignoreCase = true) or it.name.contains(searchQuery.trim(),ignoreCase = true) or it.number.contains(searchQuery.trim(),ignoreCase = true) }
    } }
    Column(modifier = Modifier.fillMaxSize().background(Color.White).padding(top =paddingValues.calculateTopPadding(), bottom = paddingValues.calculateBottomPadding())) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
        ) {

            Text(
                textAlign = TextAlign.Center,
                text = "Customers",
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.Center)
            )
            Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                IconButton(
                    onClick = {
                        searchExpanded = !searchExpanded
                    },
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_person_search_24),
                        contentDescription = "add",
                        modifier = Modifier
                    )
                }
                IconButton(onClick = {
                    onAddCustomerClick()
                }) {
                    Icon(Icons.Default.Add, contentDescription = "more")
                }
            }

        }
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 0.8.dp, color = Color.DarkGray)
if(searchExpanded){
    SearchBar(searchQuery = searchQuery, onSearchQueryChange = { query -> searchQuery = query} )

}
        LazyColumn(modifier = Modifier.fillMaxSize()){
itemsIndexed(filteredList) { index ,customer ->
    CustomerRow(
        isExpanded = expandedIndex == index,
        onClick = { expandedIndex = if(expandedIndex == index) null else index },
        customer = customer

    )
}
        }
    }
}



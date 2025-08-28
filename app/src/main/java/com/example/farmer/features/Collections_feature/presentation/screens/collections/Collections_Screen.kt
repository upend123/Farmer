package com.example.farmer.features.Collections_feature.presentation.screens.collections

import android.app.DatePickerDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.Common.Constants.FAT_RATE
import com.example.farmer.R
import com.example.farmer.features.Collections_feature.domain.model.Collection
import com.example.farmer.features.Common_features.BlankPage
import com.example.farmer.features.Common_features.CollectionScreenManuItems
import com.example.farmer.features.Common_features.SearchBar
import com.example.farmer.features.Common_features.UserInfo
import java.util.Calendar

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PrevCollections(){
//   CollectionsScreen(paddingValues = paddingValues) {}
//
//}


@Composable
fun CollectionsScreen(paddingValues: PaddingValues, onAddNewCollectionClick: () -> Unit,onShiftReport: () -> Unit = {} ,onAbsentCustomers: () -> Unit = {} ) {
//paddingValues: PaddingValues
    var isSearchExpanded by remember { mutableStateOf(false) }
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
    val context = LocalContext.current

    //remember isliye kr taki sort me manupulation ho sake
    val collectionList = remember {  mutableListOf<Collection>(Collection(code = "1", name = "Harish",fat = 6.0, fatRate = FAT_RATE.toDouble(), milkQuantity = 5.0),
        Collection(code = "2", name = "Raaavi",fat = 6.0, fatRate = FAT_RATE.toDouble(), milkQuantity = 7.0),
        Collection(code = "3",name = "Aashish",fat = 7.0 , fatRate = FAT_RATE.toDouble(), milkQuantity = 8.0),
        Collection(code = "4",name = "kelash",fat = 5.0 , fatRate = FAT_RATE.toDouble(), milkQuantity = 9.0)
    ) }
    var sortAscending by remember { mutableStateOf(true) }
    var searchQuery by remember { mutableStateOf("") }
    val filteredList by remember(searchQuery,sortAscending,collectionList) { derivedStateOf {
       val baseList = if(searchQuery.isBlank()) collectionList else collectionList.filter { it.name.contains(searchQuery.trim(),ignoreCase = true) or it.code.contains(searchQuery.trim(),ignoreCase = true)
        }
     if(sortAscending) baseList.sortedBy { it.code }
        else baseList.sortedByDescending { it.code }
    } }

    val totalItems by remember { derivedStateOf { filteredList.size } }
    val totalFat by remember { derivedStateOf { filteredList.sumOf { it.fat } } }
    val totalLiter by remember { derivedStateOf { filteredList.sumOf { it.milkQuantity } } }
    val totalAmount by remember { derivedStateOf { filteredList.sumOf { it.fat * it.fatRate * it.milkQuantity } } }
    val averageFat by remember { derivedStateOf {
        if(filteredList.isNotEmpty()){
            totalFat / totalItems
        }
        else 0.0
    } }
    var expandedIndex by remember { mutableStateOf<Int?>(null) }
var manuOptionExpanded by remember { mutableStateOf(false) }
    val manuList = listOf<Pair<String,Int>>(
        "Absent Customers" to R.drawable.baseline_supervised_user_circle_24,
        "Search" to R.drawable.baseline_person_search_24,
        "Shift Report" to R.drawable.baseline_nights_stay_24,
        "Sort: By Code" to R.drawable.baseline_sort_by_alpha_24,
        "Sort: By Time" to R.drawable.baseline_access_time_24,
        "Reconnect Printer" to R.drawable.baseline_print_24,
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom =paddingValues.calculateBottomPadding()
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Collections",
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.Center)
            )
            Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                IconButton(
                    onClick = {  onAddNewCollectionClick() },
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_add_24),
                        contentDescription = "add",
                        modifier = Modifier
                    )
                }
                Box(contentAlignment = Alignment.TopEnd) {
                    IconButton(onClick = {
                        manuOptionExpanded = !manuOptionExpanded
                    }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "more")
                    }
                    DropdownMenu(
                        expanded = manuOptionExpanded,
                        onDismissRequest = {
                            manuOptionExpanded = false
                        },
                        modifier = Modifier.align(Alignment.TopEnd)
                    ) {
                        CollectionScreenManuItems.values().forEach { item ->
                            DropdownMenuItem(
                                text = {
                                    Text(text = item.title)
                                },
                                onClick = {
                                    manuOptionExpanded = false
                                    when (item) {
                                        CollectionScreenManuItems.Absent -> {
                                            onAbsentCustomers()
                                        }

                                        CollectionScreenManuItems.Search -> {
                                            isSearchExpanded = !isSearchExpanded
                                        }

                                        CollectionScreenManuItems.ShiftReport -> {
                                            onShiftReport()
                                        }

                                        CollectionScreenManuItems.SortByCode -> {
                                            sortAscending = !sortAscending
                                            Toast.makeText(context, "SortBYCode in ${if(sortAscending) "Ascending" else "Descending"+" Order" }", Toast.LENGTH_SHORT).show()

                                        }

                                        CollectionScreenManuItems.SortByTime -> {
                                            Toast.makeText(
                                                context,
                                                "SortByTime Clicked",
                                                Toast.LENGTH_SHORT
                                            ).show()

                                        }

                                        CollectionScreenManuItems.ReconnectPrinter -> {
                                            Toast.makeText(
                                                context,
                                                "ReconnectPrinter Clicked",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    }
                                },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(item.icon),
                                        contentDescription = item.title
                                    )
                                }
                            )
                        }
                    }
                }

            }

        }
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 0.8.dp, color = Color.DarkGray)
        if (isSearchExpanded) {
            SearchBar(searchQuery =searchQuery, onSearchQueryChange = { query -> searchQuery = query})
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
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
                        text = selectedDate, fontSize = 18.sp, fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        painter = painterResource(R.drawable.baseline_date_range_24),
                        contentDescription = "dateSet",
                    )
                }


            }
            Spacer(modifier = Modifier.weight(1f))

            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.End) {
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
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 0.8.dp, color = Color.LightGray)
        if(filteredList.isNotEmpty()){   LazyColumn(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(filteredList) { index, collection ->

                UserInfo(
                    isExpanded = expandedIndex == index,
                    onClick = { expandedIndex = if (expandedIndex == index) null else index },
                    collection
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().background(Color.White)
                .padding(horizontal = 4.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TotalRowModel(text = "Total", subText = filteredList.size.toString())
            TotalRowModel(text = "FAT", subText = averageFat.toString().format("%.2f"))
            TotalRowModel(text = "Liter", subText = totalLiter.toString().format("%.2f"))
            TotalRowModel(text = "Amount", subText = totalAmount.toString().format("%.2f"))
        }
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 0.8.dp, color = Color.DarkGray)
    }else
        {
            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                BlankPage()
            }

        }
    }
}


@Composable
fun TotalRowModel(text: String,subText: String){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
  Text(text = text, fontSize = 12.sp, fontWeight = FontWeight.Medium, color = Color.DarkGray)
        Spacer(modifier = Modifier.height(4.dp))
  Text(text = subText, fontSize = 16.sp, fontWeight = FontWeight.Bold, )

    }
}




fun datePickerDialog(
    context: Context,
    onSet: (String) -> Unit,
    minDate: Calendar? = null,
    maxDate: Calendar? = null
){

    val calendar = Calendar.getInstance()
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val month = calendar.get(Calendar.MONTH)
    val year = calendar.get(Calendar.YEAR)

    val datePickerDialog =  DatePickerDialog(context,{ _,selectedYear,selectedMonth,selectedDay ->
        onSet("$selectedDay/${selectedMonth + 1}/$selectedYear")
    },year,month,day)

    minDate?.let { datePickerDialog.datePicker.minDate = it.timeInMillis }
    maxDate?.let { datePickerDialog.datePicker.maxDate = it.timeInMillis }

    datePickerDialog.show()

}


@Composable
fun morningDropdownButton(
    label : String,
    expanded : Boolean,
    onExpandChange: (Boolean) -> Unit,
    onOptionSelected : (String) -> Unit
) {
    Box {
        TextButton(onClick = { onExpandChange(!expanded) }) {

            Text(text = label, fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Icon(
                imageVector = Icons.Default.ArrowDropDown, contentDescription = null,
                modifier = Modifier.rotate(if (expanded) 180f else 0f)
            )
        }
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {
            onExpandChange(false)
        }
    ) {
        listOf(
            "Morning", "Evening"
        ).forEach { unit ->
            DropdownMenuItem(
                text = {
                    Text(
                        text = unit,
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                    )
                },
                onClick = {
                    onExpandChange(false)
                    onOptionSelected(unit)
                }

            )
        }
    }

}
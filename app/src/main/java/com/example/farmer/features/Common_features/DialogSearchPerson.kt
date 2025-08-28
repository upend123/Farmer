package com.example.farmer.features.Common_features

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevDialogSearchPerson(){
    DialogSearchPerson(show = true, onDismiss = {}, onSelected = {}, list = listOf<Pair<String, String>>("1" to "Rahul","2" to "Jalmod","3" to "Kishan","4" to "Arun"))
}
@Composable
fun DialogSearchPerson(
    show: Boolean,
    onDismiss: () -> Unit,
    onSelected: (Pair<String, String>) -> Unit,
    list: List<Pair<String, String>>,

    ){
   var searchQuery by remember { mutableStateOf("") }
    var filteredList = if(searchQuery.isBlank()) list else list.filter { it.second.contains(searchQuery.trim(),ignoreCase = true) or it.first.contains(searchQuery.trim(),ignoreCase = true) }
        if(show){
        Dialog(

            onDismissRequest = {
                onDismiss()
            },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 26.dp, vertical = 26.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp))
,
            ){
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)){
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                        IconButton(onClick = { onDismiss() }){
                            Icon(Icons.Default.ArrowBack, contentDescription = "back", tint = Color.DarkGray)
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                        Text(text = "Customer", fontWeight = FontWeight.Medium, fontSize = 20.sp, color = Color.DarkGray)
                    }
                    TextField(
                        value = searchQuery,
                        onValueChange = {
                            searchQuery = it
                        },
                        textStyle = TextStyle(fontSize = 18.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        leadingIcon = {
                            Icon(Icons.Default.Search, contentDescription = null)
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp),
                        placeholder = {
                            Text(text = "Type here to search", fontSize = 18.sp)
                        },
                        colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        ),
                        trailingIcon = {
                           IconButton(onClick = { searchQuery = ""}) {
                               if(searchQuery.isNotBlank()){ Icon(Icons.Default.Clear, contentDescription = null) }
                           }
                        }

                    )
                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                     items(filteredList){ customer ->
                         CustomerWithCodeRow(customer, onClick = { customer ->
                                                        onSelected(customer)
                         })
                     }
                    }


                }
            }
        }
    }
}

@Composable
fun CustomerWithCodeRow(customer: Pair<String, String>,onClick: (Pair<String, String>) -> Unit) {
   var checked by remember { mutableStateOf(false) }
    if(checked) onClick(customer)
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable(onClick = {
            checked = true
            onClick(customer)
        }), verticalAlignment = Alignment.CenterVertically) {
     Checkbox(checked = checked, onCheckedChange = {
checked = !checked
     })
     Text(text = "${customer.first}: ${customer.second}", fontSize = 20.sp, fontWeight = FontWeight.Medium, color = Color.DarkGray, )
 }
}
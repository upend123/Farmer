package com.example.farmer.features.Common_features.CustomerRow

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import com.example.farmer.features.Customers_feature.domain.model.Customer

@Composable
fun CustomerRow(
    isExpanded: Boolean,
    onClick: () -> Unit,
    customer: Customer
){
    val code = customer.code
    val name = customer.name
    val number = customer.number

var onDeleteAlert by remember { mutableStateOf(false) }

    Row(modifier = Modifier
        .clickable(onClick = {onClick()})
        .fillMaxWidth()
        .background(Color.White)
        .padding(4.dp), verticalAlignment = Alignment.CenterVertically) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
            Box(
                modifier = Modifier
                    .size(48.dp) // equal height and width = perfect circle
                    .border(
                        width = 1.dp,
                        color = Color.DarkGray,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = code,
                    fontSize = if(code.length > 4) 14.sp else 16.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){
                Text(text = name, fontSize = 18.sp, fontWeight = FontWeight.Medium )
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(4.dp)) {
                    Text(text = "$number", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color.DarkGray) }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
            Icon(Icons.Default.ArrowDropDown, tint = Color.DarkGray, contentDescription = "dropdown", modifier = Modifier.rotate(if (isExpanded) 180f else 0f))
        }
    }
    if(isExpanded){
        Row(modifier = Modifier.fillMaxWidth().background(Color.White).padding(10.dp), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            IconButton(onClick = {} ) {
                Box(modifier = Modifier.size(48.dp).border(width = 1.dp, color = Color.DarkGray, shape = CircleShape), contentAlignment = Alignment.Center,){
                    Icon(painter = painterResource(R.drawable.baseline_edit_24), contentDescription = null, modifier = Modifier.size(24.dp))
                }
            }
            IconButton(onClick = {
                onDeleteAlert = true
            } ) {
                Box(modifier = Modifier.size(48.dp).border(width = 1.dp, color = Color.DarkGray, shape = CircleShape), contentAlignment = Alignment.Center,){
                    Icon(painter = painterResource(R.drawable.baseline_delete_24), contentDescription = null, modifier = Modifier.size(24.dp))
                }
            }
            IconButton(onClick = {} ) {
                Box(modifier = Modifier.size(48.dp).border(width = 1.dp, color = Color.DarkGray, shape = CircleShape), contentAlignment = Alignment.Center,){
                    Icon(painter = painterResource(R.drawable.baseline_currency_rupee_24), contentDescription = null, modifier = Modifier.size(24.dp))
                }
            }
            IconButton(onClick = {} ) {
                Box(modifier = Modifier.size(48.dp).border(width = 1.dp, color = Color.DarkGray, shape = CircleShape), contentAlignment = Alignment.Center,){
                    Icon(painter = painterResource(R.drawable.baseline_insert_chart_outlined_24), contentDescription = null, modifier = Modifier.size(24.dp))
                }
            }
            IconButton(onClick = {} ) {
                Box(modifier = Modifier.size(48.dp).border(width = 1.dp, color = Color.DarkGray, shape = CircleShape), contentAlignment = Alignment.Center,){
                    Icon(painter = painterResource(R.drawable.whatsapp_icon), contentDescription = null, modifier = Modifier.size(24.dp), tint = Color.Unspecified)
                }
            }
            IconButton(onClick = {} ) {
                Box(modifier = Modifier.size(48.dp).border(width = 1.dp, color = Color.DarkGray, shape = CircleShape), contentAlignment = Alignment.Center,){
                    Icon(painter = painterResource(R.drawable.baseline_receipt_long_24), contentDescription = null, modifier = Modifier.size(24.dp))
                }
            }
        }
    }
    Divider(modifier = Modifier.fillMaxWidth(), thickness = 0.8.dp, color = Color.LightGray)
    if(onDeleteAlert){
            com.example.farmer.features.Common_features.AlertDialog.AlertDialog(isDeleteCollection = onDeleteAlert, onChange = { onDeleteAlert = it}, onConfirmRequest = { onClick() })

    }
}
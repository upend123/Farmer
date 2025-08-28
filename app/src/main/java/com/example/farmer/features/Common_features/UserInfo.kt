package com.example.farmer.features.Common_features

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import   androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import com.example.farmer.features.Collections_feature.domain.model.Collection

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevUserInfo(){
    UserInfo(isExpanded = true, onClick = {}, collection = Collection(code = "123", name = "jija", fat = 5.6, fatRate = 6.5, milkQuantity = 8.0))
}

@Composable
fun UserInfo(
  isExpanded: Boolean,
  onClick: () -> Unit,
  collection: Collection,
  onDeleteClick: () -> Unit = {},
  onEditClick: () -> Unit = {},
  onShareClick: () -> Unit = {},
){
    val code = collection.code
    val name = collection.name
    val FAT = collection.fat
    val RatePerFAT = collection.fatRate
    val milkQuantity = collection.milkQuantity

    var isDeleteCollection by remember { mutableStateOf(false) }
    //Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp, bottom = 16.dp) , verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

    Row(modifier = Modifier
            .clickable(onClick = {onClick()})
            .fillMaxWidth()
            .background(Color.White)
            .padding(3.dp), verticalAlignment = Alignment.CenterVertically) {
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
                Column( verticalArrangement = Arrangement.Center, modifier = Modifier.height(64.dp).width(150.dp)){
                    Text(text = name, modifier = Modifier.width(150.dp), overflow = TextOverflow.Ellipsis, maxLines = 1, fontSize = if(name.length > 20) 14.sp else 16.sp, softWrap = false, fontWeight = FontWeight.Medium )
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier.padding(4.dp)) {
                        Icon(painter = painterResource(R.drawable.baseline_flutter_dash_24), contentDescription = "FAT", modifier = Modifier.padding(4.dp))
                        Text(text = "FAT: $FAT", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color.Blue ) }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){
                    Text(text =" ${(FAT * RatePerFAT)*milkQuantity} ₹", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.Green )
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(4.dp)) {
                        Text(text = "${( FAT * RatePerFAT)} x ${milkQuantity}L", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color.Gray ) }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Icon(Icons.Default.ArrowDropDown, contentDescription = "dropdown", modifier = Modifier.rotate(if (isExpanded) 180f else 0f))
            }
        }
        if(isExpanded){
            Row(modifier = Modifier.fillMaxWidth().background(Color.White).padding(10.dp), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                IconButton(onClick = {
                     onEditClick()
                } ) {
                    Box(modifier = Modifier.size(48.dp).border(width = 1.dp, color = Color.DarkGray, shape = CircleShape), contentAlignment = Alignment.Center,){
                        Icon(painter = painterResource(R.drawable.baseline_edit_24), contentDescription = null, modifier = Modifier.size(24.dp))
                    }
                }
                IconButton(onClick = {
                    isDeleteCollection  = true
                } ) {
                    Box(modifier = Modifier.size(48.dp).border(width = 1.dp, color = Color.DarkGray, shape = CircleShape), contentAlignment = Alignment.Center,){
                        Icon(painter = painterResource(R.drawable.baseline_delete_24), contentDescription = null, modifier = Modifier.size(24.dp))
                    }
                }
                IconButton(onClick = {} ) {
                    Box(modifier = Modifier.size(48.dp).border(width = 1.dp, color = Color.DarkGray, shape = CircleShape), contentAlignment = Alignment.Center,){
                        Icon(painter = painterResource(R.drawable.baseline_share_24), contentDescription = null, modifier = Modifier.size(24.dp))
                    }
                }
                IconButton(onClick = {} ) {
                    Box(modifier = Modifier.size(48.dp).border(width = 1.dp, color = Color.DarkGray, shape = CircleShape), contentAlignment = Alignment.Center,){
                        Icon(painter = painterResource(R.drawable.baseline_print_24), contentDescription = null, modifier = Modifier.size(24.dp))
                    }
                }
                IconButton(onClick = {} ) {
                    Box(modifier = Modifier.size(48.dp).border(width = 1.dp, color = Color.DarkGray, shape = CircleShape), contentAlignment = Alignment.Center,){
                        Icon(painter = painterResource(R.drawable.whatsapp_icon), contentDescription = null, modifier = Modifier.size(24.dp), tint = Color.Unspecified)
                    }
                }
                IconButton(onClick = {} ) {
                    Box(modifier = Modifier.size(48.dp).border(width = 1.dp, color = Color.DarkGray, shape = CircleShape), contentAlignment = Alignment.Center,){
                        Icon(painter = painterResource(R.drawable.baseline_message_24), contentDescription = null, modifier = Modifier.size(24.dp))
                    }
                }
            }
        }
  if(isDeleteCollection){
      com.example.farmer.features.Common_features.AlertDialog.AlertDialog(isDeleteCollection = isDeleteCollection, onChange = { isDeleteCollection = it}, onConfirmRequest = { onClick()})
  }
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 0.8.dp, color = Color.LightGray)

    }




// }

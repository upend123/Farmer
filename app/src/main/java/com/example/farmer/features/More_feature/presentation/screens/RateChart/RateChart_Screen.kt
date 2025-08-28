package com.example.farmer.features.More_feature.presentation.screens.RateChart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.features.Common_features.HeaderWithoutManuIcon

import com.example.farmer.ui.theme.BlueJC


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevRateChartScreen(){
    RateChartScreen()
}

@Composable
fun RateChartScreen(
    onBackClick:() -> Unit = {}
) {
    val fatValues = (10..200).map { it/10.0 }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 16.dp // paddingValues.calculateTopPadding(),
                , bottom = 16.dp//paddingValues.calculateBottomPadding()
            )
    ) {
        HeaderWithoutManuIcon(
            title = "Rate chart",
            onBackClick = {
                onBackClick()
            }
        )
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround){
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
                Box(modifier = Modifier
                    .border(width = 1.dp, color = Color.DarkGray, shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp))
                    .background(Color.LightGray),){
                  TextButton(onClick = {}, modifier = Modifier
                      .size(74.dp)
                      .align(Alignment.Center)) { Text(text = "Buffalo", fontSize = 15.sp, fontWeight = FontWeight.Bold) }
                }
                Box(modifier = Modifier.border(width = 1.dp, color = Color.DarkGray, shape = RoundedCornerShape(bottomEnd = 4.dp, topEnd = 4.dp))){
                    TextButton(onClick = {}, modifier = Modifier
                        .size(74.dp)
                        .align(Alignment.Center)) { Text(text = "Cow", fontSize = 15.sp, fontWeight = FontWeight.Bold) }
                }
            }

            Box( modifier = Modifier
                .height(60.dp)
                .background(BlueJC, shape = RoundedCornerShape(15.dp))
                .padding(16.dp), contentAlignment = Alignment.Center) {
                Text(text = "MAKE A CHANGE", color = Color.White, fontWeight = FontWeight.Medium, fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Center))
            }
        }
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 0.8.dp, color = Color.DarkGray)
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally){
item { Row(modifier = Modifier
    .fillMaxWidth()
    .padding(4.dp)
    .background(Color.White)){
    Box(modifier = Modifier
        .weight(0.5f)
        .border(width = 0.3.dp, color = Color.LightGray,)){
        Text(text = "FAT", fontWeight = FontWeight.Medium, fontSize = 16.sp, modifier = Modifier.align(
            Alignment.Center))
    }
    Box(modifier = Modifier
        .weight(0.5f)
        .border(width = 0.3.dp, color = Color.LightGray,)){
        Text(text = "Price", fontWeight = FontWeight.Medium, fontSize = 16.sp, modifier = Modifier.align(
            Alignment.Center))
    }
} }
         itemsIndexed(fatValues) { index ,fat ->
             FatRateLayer(fat = fat , price = fat * 7,index = index)
         }
            }
        }
    }


@Composable
fun FatRateLayer(fat: Double, price: Double, index: Int){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(if(index%2 == 0) Color.LightGray else Color.White)){
        Box(modifier = Modifier
            .weight(0.5f)
            .border(width = 0.3.dp, color = Color.LightGray,).padding(2.dp)){
            Text(text = "${String.format("%.1f",fat)}", fontWeight = FontWeight.Medium, fontSize = 16.sp, modifier = Modifier.align(
                Alignment.Center))
        }
        Box(modifier = Modifier
            .weight(0.5f)
            .border(width = 0.3.dp, color = Color.LightGray,).padding(2.dp)){
            Text(text = "${String.format("%.2f",price)}", fontWeight = FontWeight.Medium, fontSize = 16.sp, modifier = Modifier.align(
                Alignment.Center))
        }
    }
}
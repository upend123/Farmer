package com.example.farmer.features.More_feature.presentation.screens.Products

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import com.example.farmer.features.Common_features.HeaderWithManu


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun prevProducts(){
    ProductsScreen()
}

@Composable
fun ProductsScreen(
    onBackClick:() -> Unit ={},
    onAddProductClick:() -> Unit = {}
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
            title = "Products",
            isFirstTrailingIcon = true,
            secondTrailingIcon = R.drawable.baseline_more_vert_24
      , onBackClick = {
                onBackClick()
            },
            onAddClick = {
                onAddProductClick()
            }
        )
        LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                Text(text = "No Records", fontWeight = FontWeight.Medium, fontSize = 18.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Press + to add new record", fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.DarkGray)

            }
        }
    }



}
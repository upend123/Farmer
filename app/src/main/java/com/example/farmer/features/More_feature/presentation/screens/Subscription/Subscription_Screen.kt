package com.example.farmer.features.More_feature.presentation.screens.Subscription


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
import com.example.farmer.features.Common_features.HeaderWithoutManuIcon


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun prevSubscription(){
    SubscriptionScreen()
}

@Composable
fun SubscriptionScreen(
    onBackClick:() -> Unit = {}
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 16.dp // paddingValues.calculateTopPadding(),
                , bottom =  16.dp//paddingValues.calculateBottomPadding()
            )
    ) {
        HeaderWithoutManuIcon(title = "Subscription",
            onBackClick = {onBackClick()})
        LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                Text(text = "No Active Plan", fontWeight = FontWeight.Medium, fontSize = 18.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Press add Active Plans", fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.DarkGray)

            }
        }
    }



}
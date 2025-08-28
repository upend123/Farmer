package com.example.farmer.features.Common_features

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BlankPage(title: String = "No Records",description: String = "Press + to add new record"){
    Text(text = title, fontWeight = FontWeight.Medium, fontSize = 18.sp, color = Color.DarkGray)
    Spacer(modifier = Modifier.height(4.dp))
    Text(text = description, fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.DarkGray)

}
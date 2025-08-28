package com.example.farmer.features.More_feature.presentation.screens.Language

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import com.example.farmer.features.Common_features.ReportRow
import com.example.farmer.ui.theme.BlueJC


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevLanguageScreen(){
    LanguageScreen()
}

@Composable
fun LanguageScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 16.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BlueJC)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Select Preferred Language!",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 24.sp
                )
                Spacer(Modifier.height(6.dp))
            }
        }
        item {
            ReportRow(icon = R.drawable.baseline_language_24, title = "Hindi (हिन्दी)", onClick = {})
        }
        item {
            ReportRow(icon = R.drawable.baseline_language_24, title = "Gujarati (गुजराती)", onClick = {})
        }
        item {
            ReportRow(icon = R.drawable.baseline_language_24, title = "English", onClick = {})
        }
        item {
            ReportRow(icon = R.drawable.baseline_language_24, title = "Marathi (मराठी)", onClick = {})
        }
        item {
            ReportRow(icon = R.drawable.baseline_language_24, title = "Kannada (कन्नड)", onClick = {})
        }

    }



}




package com.example.farmer.features.Reports_feature.presentation.screens.Customers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.farmer.R
import com.example.farmer.features.Common_features.BlankPage
import com.example.farmer.features.Common_features.HeaderWithoutManuIcon


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomersReport(onBackClick: () -> Unit = {}){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 16.dp, bottom = 16.dp)) {
        HeaderWithoutManuIcon(title = "Customers",backIcon = true,isFirstTrailingIcon = true, isSecondMoreTrailingIcon = true, firstTrailingIcon = R.drawable.baseline_print_24, secondTrailingIcon = R.drawable.baseline_screen_share_24, isDateAndMorningBar = false, onSecondTrailingIconClick = {} , onFirstTrailingIconClick = {} , onBackClick = {onBackClick()},)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                BlankPage()
            }
        }
    }
}
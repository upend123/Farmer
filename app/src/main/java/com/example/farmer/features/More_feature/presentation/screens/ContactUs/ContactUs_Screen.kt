package com.example.farmer.features.More_feature.presentation.screens.ContactUs

import androidx.annotation.DrawableRes
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import com.example.farmer.features.Common_features.HeaderWithManu


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevContactUsScreen(){
    ContactUsScreen()
}

@Composable
fun ContactUsScreen(onBackClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 16.dp // paddingValues.calculateTopPadding(),
                , bottom = 16.dp//paddingValues.calculateBottomPadding()
            )
    ) {
        HeaderWithManu(
            title = "Contact Us", secondTrailingIcon = R.drawable.baseline_more_vert_24
       , onBackClick = {onBackClick()}, onAddClick = {}
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, bottom = 16.dp)
        ) {
            item {
                ReportRow(
                    icon = R.drawable.baseline_link_24,
                    title = "Website",
                    subtitle = "https://milkcollectionsystem.in"
                )
            }
            item {
                ReportRow(
                    icon = R.drawable.baseline_mail_outline_24,
                    title = "Email",
                    subtitle = "support@milkcollectionsystem.in"
                )
            }
            item {
                ReportRow(
                    icon = R.drawable.whatsapp_icon,
                    title = "WhatApp",
                    subtitle = "2536455656"
                )
            }
        }


    }
}


    @Composable
    fun ReportRow(@DrawableRes icon: Int, title: String, subtitle: String) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp), elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(36.dp),
                    tint = Color.Unspecified
                )
                Column {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                    Text(
                        text = subtitle,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }




package com.example.farmer.features.More_feature.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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

@Composable
fun MoreScreen(paddingValues: PaddingValues,
               onMilkSalesClick: () -> Unit,
               onSalesClick: () -> Unit,
               onMemberPaymentClick: () -> Unit,
               onDairyInformationClick: () -> Unit,
               onSettingClick: () -> Unit,
               onRateChartClick: () -> Unit,
               onProductsClick: () -> Unit,
               onSubscriptionClick: () -> Unit,
               onPersonalDetailsClick: () -> Unit,
               onLanguageClick: () -> Unit,
               onVideoClick: () -> Unit,
               onContactUsClick: () -> Unit,
               onRateThisAppClick: () -> Unit,
               onShareThisAppClick: () -> Unit,
               onLogoutClick: () -> Unit

){


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
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
                        text = "Hello Upendra Yadav!",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 24.sp
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "+919302675347",
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                    )
                }
            }
            item {
                ReportRow(icon = R.drawable.baseline_nights_stay_24, title = "Milk Sales", onClick = { onMilkSalesClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_request_page_24, title = "Sales", onClick = { onSalesClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_library_books_24, title = "Member Payment", onClick = { onMemberPaymentClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_credit_card_24, title = "Dairy Information", onClick = { onDairyInformationClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_contact_page_24, title = "Setings", onClick = { onSettingClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_insert_chart_outlined_24, title = "Rate chart", onClick = { onRateChartClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_receipt_long_24, title = "Products", onClick = { onProductsClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_nights_stay_24, title = "Subscription", onClick = { onSubscriptionClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_request_page_24, title = "Personal Details", onClick = { onPersonalDetailsClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_language_24, title = "Language", onClick = { onLanguageClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_smart_display_24, title = "Video", onClick = { onVideoClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_contact_phone_24, title = "Contact Us", onClick = { onContactUsClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_star_24, title = "Rate this App", onClick = { onRateThisAppClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_share_24, title = "Share this app", onClick = { onShareThisAppClick() })
            }
            item {
                ReportRow(icon = R.drawable.baseline_logout_24, title = "Logout", onClick = { onLogoutClick() })
            }
            item {

                Text(
                    text = "V5.4.6 (159)",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    color = Color.DarkGray
                )
            }
        }



}
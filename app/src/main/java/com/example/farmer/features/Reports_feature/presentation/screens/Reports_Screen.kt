package com.example.farmer.features.ReportRows_feature.presentation.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import com.example.farmer.features.Common_features.ReportRow
import com.example.farmer.ui.theme.BlueJC

@Composable
fun ReportsScreen(paddingValues: PaddingValues,
                  onCreditOrDebitReportClick:() -> Unit,
                  onPaymentAndSalesReportClick:() -> Unit,
                  onCustomerReportClick: () -> Unit,
                  onPaymentRegisterClick: () -> Unit,
                  onPaymentReportClick: () -> Unit,
                  onSalesReportClick: () -> Unit,
                  onShiftReportClick: () -> Unit,
                  ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding()
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Reports",
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 0.8.dp, color = Color.DarkGray)
        LazyColumn(modifier = Modifier.fillMaxSize()){
            item {
                ReportRow(icon = R.drawable.baseline_nights_stay_24,title = "Shift Report", onClick = {onShiftReportClick()})
            }
            item {
                ReportRow(icon = R.drawable.baseline_request_page_24,title = "Payment Report", onClick = { onPaymentReportClick()})
            }
            item {
                ReportRow(icon = R.drawable.baseline_library_books_24,title = "Payment Register", onClick = {onPaymentRegisterClick()})
            }
            item {
                ReportRow(icon = R.drawable.baseline_credit_card_24,title = "Credit/Debit Report", onClick = { onCreditOrDebitReportClick()})
            }
            item {
                ReportRow(icon = R.drawable.baseline_contact_page_24,title = "Customer", onClick = {onCustomerReportClick()})
            }
            item {
                ReportRow(icon = R.drawable.baseline_insert_chart_outlined_24,title = "Sales Report", onClick = {onSalesReportClick()})
            }
            item {
                ReportRow(icon = R.drawable.baseline_receipt_long_24,title = "Payment & Sales Report", onClick = {onPaymentAndSalesReportClick()})
            }

        }
    }
}

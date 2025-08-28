package com.example.farmer.features.More_feature.presentation.screens.Settings

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.features.Common_features.HeaderWithoutManuIcon

import com.example.farmer.features.Common_features.NonPrimitiveTextField
import com.example.farmer.features.Common_features.TextFieldOptionsRow
import com.example.farmer.ui.theme.BlueJC
import com.example.farmer.ui.theme.LightBlue

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PrevSettingsScreen(){
    SettingsScreen(onBackClick = {})
}

@Composable
fun SettingsScreen(
    onBackClick:() -> Unit
) {
    var paymentSlipMassage by remember { mutableStateOf("") }
    var dairyNameInSMS by remember { mutableStateOf("") }

    val context = LocalContext.current
    var isCheckedTotalCollection by remember { mutableStateOf(false) }
    var  isCheckedBluetooth  by remember { mutableStateOf(false) }
    var  isCheckedDairyNameinSMS  by remember { mutableStateOf(false) }
    var  isCheckedCustomerNameinSMS  by remember { mutableStateOf(false) }
    var postCollectionActionOptions = listOf<String>("Save","Send SMS","Send WhatsApp","Print","Share","SMS & Print","WhatsApp & Print")
    var SMSAppOptions = listOf<String>("Default","Upendra SMS",)
    var paymentSlipReportOption = listOf<String>("Paper Roll","A4",)
    var paymentSlipRegisterOption = listOf<String>("Default","Large",)
    var printerBluetoothOptions = listOf<String>("UiNB-5661","Laptop-5A3SOHJ","UiNB-6003","TWS 5067","TWS","HC-05")

    var selectedPostCollectionAction by remember { mutableStateOf(postCollectionActionOptions[0]) }
    var selectedPrinterBluetooth by remember { mutableStateOf(printerBluetoothOptions[0]) }
    var selectedSMSApp by remember { mutableStateOf(SMSAppOptions[0]) }
    var selectedPaymentSlipReport by remember { mutableStateOf(paymentSlipReportOption[0]) }
    var selectedPaymentSlipRegister by remember { mutableStateOf(paymentSlipRegisterOption[0]) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 16.dp // paddingValues.calculateTopPadding(),
                , bottom = 16.dp//paddingValues.calculateBottomPadding()
            )
    ) {
        Column(modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter)) {
            HeaderWithoutManuIcon(
                title = "Settings",
                onBackClick = {
                    onBackClick()
                }
            )

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                            .background(LightBlue),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Collections",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        )
                    }

                    TextFieldOptionsRow(
                        options = postCollectionActionOptions,
                        label = "Post Collection Action",
                        selectedOption = selectedPostCollectionAction,
                        onSelectedOption = {selectedPostCollectionAction = it}
                    )
                    NonPrimitiveTextField(label = "Payment Slip Message", value = paymentSlipMassage, onValueChange = { paymentSlipMassage = it})
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Total Collection Liters & Amount",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = null,
                            tint = Color.DarkGray,
                            modifier = Modifier.padding(10.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Switch(
                            checked = isCheckedTotalCollection,
                            onCheckedChange = {
                                isCheckedTotalCollection = it
                            },
                        )
                    }
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                            .background(LightBlue),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Milk Sales",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        )
                    }
                    TextFieldOptionsRow(
                        options = postCollectionActionOptions,
                        label = "Post Milk sales action",
                        selectedOption = selectedPostCollectionAction,
                        onSelectedOption = { selectedPostCollectionAction = it}
                    )
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                            .background(LightBlue),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Printer",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        )
                    }
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Bluetooth Printer?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.weight(1f))

                            Switch(
                                checked = isCheckedBluetooth,
                                onCheckedChange = {
                                    isCheckedBluetooth = it
                                },
                            )
                            Spacer(modifier = Modifier.width(36.dp))
                            Icon(
                                Icons.Default.Settings,
                                contentDescription = null,
                                tint = Color.DarkGray,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .size(30.dp)
                            )

                        }
                        if (isCheckedBluetooth) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconButton(onClick = {}, modifier = Modifier.align(Alignment.CenterVertically)) {
                                    Icon(
                                        Icons.Default.Refresh,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .size(34.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                TextFieldOptionsRow(
                                    options = printerBluetoothOptions,
                                    label = "Printer",
                                    selectedOption = selectedPrinterBluetooth,
                                    onSelectedOption = { selectedPrinterBluetooth = it
                                    }
                                )

                            }
                        }

                    }
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                            .background(LightBlue),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "SMS",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(6.dp)
                        )
                        Text(
                            text = "Help?",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(6.dp),
                            color = BlueJC
                        )

                    }
                    TextFieldOptionsRow(options = SMSAppOptions, label = "SMS App",
                        selectedOption = selectedSMSApp,
                        onSelectedOption = {
                            selectedSMSApp = it
                        })
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Dairy name in SMS",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.weight(1f))

                            Switch(
                                checked = isCheckedDairyNameinSMS,
                                onCheckedChange = {
                                    isCheckedDairyNameinSMS = it
                                },
                            )

                        }
                        if (isCheckedDairyNameinSMS) {
                            NonPrimitiveTextField(label = "Dairy name in SMS", value = dairyNameInSMS, onValueChange = {dairyNameInSMS = it})
                        }
                    }
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Customer name in SMS",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.weight(1f))

                            Switch(
                                checked = isCheckedCustomerNameinSMS,
                                onCheckedChange = {
                                    isCheckedCustomerNameinSMS = it
                                },
                            )

                        }

                        if (isCheckedCustomerNameinSMS) {
                            NonPrimitiveTextField(label = "Dairy name in SMS", value = dairyNameInSMS, onValueChange = { dairyNameInSMS = it})
                        } else {
                            Text(
                                text = "SMS will be send from your mobile's SIM card. Please ensure you have an active SMS plan.",
                                fontSize = 16.sp,
                                color = Color.Magenta,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                            .background(LightBlue),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Reports",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        )

                    }
                    TextFieldOptionsRow(
                        options = paymentSlipReportOption,
                        label = "Payment Slip Report - Page Type",
                        selectedOption = selectedPaymentSlipReport,
                        onSelectedOption = { selectedPaymentSlipReport = it}
                    )
                    TextFieldOptionsRow(
                        options = paymentSlipRegisterOption,
                        label = "Payment Register - Row Spacing",
                        selectedOption = selectedPaymentSlipRegister,
                        onSelectedOption = { selectedPaymentSlipRegister = it}
                    )

                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                            .background(LightBlue),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Users",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(2.dp)
                        )
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.Add, contentDescription = null, modifier = Modifier
                                    .padding(4.dp)
                                    .size(28.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Upendra Yadav", fontSize = 18.sp, color = Color.Gray)
                            Spacer(Modifier.height(4.dp))
                            Text(text = "+919314453535", fontSize = 16.sp, color = Color.Gray)
                        }
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Owner", fontSize = 16.sp, color = Color.Gray)
                            Icon(
                                Icons.Default.Lock,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                        }

                    }
                }
                item {
                    Spacer(
                        Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                }

            }

        }
      //  Spacer(modifier = Modifier.height(100.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .align(Alignment.BottomCenter), contentAlignment = Alignment.Center){
            TextButton(onClick = {
                Toast.makeText(context,"Dairy Information Saved", Toast.LENGTH_SHORT).show()
            }, modifier = Modifier
                .fillMaxWidth()
                .background(color = BlueJC, shape = RoundedCornerShape(12.dp))) {
                Text(text = "Save", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(6.dp))
            }
        }

    }

        }
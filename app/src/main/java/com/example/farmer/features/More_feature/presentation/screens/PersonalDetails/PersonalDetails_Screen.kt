package com.example.farmer.features.More_feature.presentation.screens.PersonalDetails


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import com.example.farmer.features.Common_features.HeaderWithManu

import com.example.farmer.ui.theme.BlueJC
import com.example.farmer.ui.theme.PurpleGrey80


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun prevPersonalDetails(){
    PersonaDetailsScreen()
}

@Composable
fun PersonaDetailsScreen(
    onBackClick:() -> Unit = {},
    onPersonalDetailClick: () -> Unit ={},
    onDeleteAccountClick: () -> Unit ={}
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 16.dp // paddingValues.calculateTopPadding(),
                , bottom =  16.dp//paddingValues.calculateBottomPadding()
            )
    ) {
        HeaderWithManu(title = "Personal Details", secondTrailingIcon = R.drawable.baseline_more_vert_24, onBackClick = { onBackClick()}, onAddClick = {})
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

                Row(modifier = Modifier.fillMaxWidth().padding(16.dp).background(PurpleGrey80,shape = RoundedCornerShape(15.dp)).clickable(onClick = {
                    onPersonalDetailClick()
                }), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Person, contentDescription = null , tint = BlueJC,modifier = Modifier.padding(10.dp).size(38.dp))
                    Text(text = "Personal Details", fontWeight = FontWeight.Medium, fontSize = 18.sp, modifier = Modifier.padding(6.dp))
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, modifier = Modifier.padding(8.dp))
            }
                Row(modifier = Modifier.fillMaxWidth().padding(16.dp).background(PurpleGrey80, shape = RoundedCornerShape(15.dp)).clickable(onClick = {
                    onDeleteAccountClick()
                }), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(R.drawable.baseline_no_accounts_24), contentDescription = null , tint = BlueJC,modifier = Modifier.padding(10.dp).size(38.dp))
                    Text(text = "Delete Account", fontWeight = FontWeight.Medium, fontSize = 18.sp, modifier = Modifier.padding(6.dp))
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, modifier = Modifier.padding(8.dp))
                }
        }
    }



}
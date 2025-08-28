package com.example.farmer.features.Splash_feature

import android.widget.ProgressBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer.R
import kotlinx.coroutines.delay

@Composable
fun Splash(
    navigateHome: () -> Unit
){

    LaunchedEffect(Unit) {
        delay(3000L)
        navigateHome()
    }

    Box(modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center ){

        Column(modifier = Modifier.wrapContentWidth().wrapContentHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Icon(
                painter = painterResource(R.drawable.baseline_water_drop_24),
                contentDescription = "logo", modifier = Modifier.size(100.dp)
            )
            Text(text = "Farmer", textAlign = TextAlign.Center, modifier = Modifier.align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(10.dp))
            CircularProgressIndicator()

        }

      Box(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter)){
          Text(text = "Developed By Upendra Yadav",  fontWeight = FontWeight.Medium, fontSize = 16.sp, modifier = Modifier.wrapContentHeight().wrapContentWidth().padding(bottom = 16.dp).align(Alignment.BottomCenter))

      }
   }


}
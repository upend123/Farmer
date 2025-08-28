package com.example.farmer.features.Home_feature.presentation.screens

import android.app.Activity
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.farmer.R
import com.example.farmer.ui.theme.BlueJC
import com.example.farmer.ui.theme.PurpleGrey40
import com.example.farmer.ui.theme.PurpleGrey80

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PrevHomeScreen(){
//    RawRow()
//}

@Composable
fun HomeScreen(paddingValues: PaddingValues){
    val view = LocalView.current
    if(!view.isInEditMode){
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = androidx.compose.ui.graphics.Color(0xFF1F73DE).toArgb()

        }
    }

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)){
       item {
           Column(modifier = Modifier
               .fillMaxWidth()
               .background(BlueJC)
               .padding(16.dp),
               verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start){
               Text(
                   text = "Hello Upendra Yadav!",
                   fontWeight = FontWeight.Bold,
                   color = Color.White,
                   fontSize = 24.sp
               )
               Spacer(Modifier.height(4.dp))
               Text(text = "Jai Singaji",
                   color = Color.White,
                   fontWeight = FontWeight.Medium,
                   fontSize = 18.sp,
               )
           }
       }
        item {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(BlueJC, Color.Magenta)
                    ), shape = RoundedCornerShape(15.dp)
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Icon(modifier = Modifier
                    .size(50.dp)
                    .weight(0.3f),
                    painter = painterResource(R.drawable.baseline_play_circle_24)
                , contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))

                Column (modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(text = "Watch the video to understand how to use the app",
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                        color = Color.White,
                        softWrap = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Start)
                            .padding(top = 10.dp, start = 10.dp, end = 10.dp))
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp, horizontal = 10.dp),
                        horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {

                        Text(text = "View >", fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.LightGray, softWrap = true,
                            )

                    }
                }
            }

        }
        item {
            RawRow(
                title = "Ask a Question | Need help?",
                description = "Ask our AI Chat Bot for quick answers to your questions about the app and its features",
                icon = painterResource(R.drawable.baseline_feedback_24),
                tint = BlueJC
            )
        }
        item {
            RawRow(
                title = "Recharge Now",
                description = "Take advantages of our premium offering - upgrade to a paid plan now!",
                icon = painterResource(R.drawable.baseline_credit_card_24),
                tint = BlueJC
            )
        }
        item {
            RawRow(
                title = "Video",
                description = "Watch the video to understand how to use the app",
                icon = painterResource(R.drawable.baseline_smart_display_24),
                tint = BlueJC
            )
        }
        item {
            RawRow(
                title = "Help ?",
                description = "How can I help you? please WhatsApp us",
                icon = painterResource(R.drawable.whatsapp_icon),
                tint = Color.Unspecified
            )
        }
        item {
            RawRow(
                title = "Join WhatsApp Group",
                description = "Join our WhatsApp group to get the latest updates and offers. Click here to join and tap on `Join Community`!",
                icon = painterResource(R.drawable.whatsapp_icon),
                tint = Color.Unspecified
            )
        }
        item {
            RawRow(
                title = "Rate this app",
                description = "Love the app? Help us shine with your 5-star review on Google Play Store!",
                icon = painterResource(R.drawable.baseline_star_24),
                tint = BlueJC
            )
        }

    }
}

@Composable
fun RawRow(
 title : String,
 description: String,
  icon: Painter,
 tint: Color
){

    Card(modifier = Modifier .fillMaxWidth()
        .padding(bottom = 10.dp, start = 10.dp, end = 10.dp, top = 3.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth().background(Color.White),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Icon(
                painter = icon,
                modifier = Modifier
                    .size(50.dp)
                    .padding(10.dp),
                tint = tint, contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = description,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 6.dp),
                    softWrap = true

                )
            }
            Text(
                text = ">",
                fontWeight = FontWeight.Medium,
                fontSize = 26.sp,
                color = Color.Gray,
                modifier = Modifier.padding(end = 10.dp, start = 5.dp)
            )

        }
    }

}
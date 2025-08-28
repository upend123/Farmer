
import androidx.annotation.DrawableRes
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farmer.R
import com.example.farmer.navigation.bottomBarNavigation.BottomBarRoutes
import com.example.farmer.navigation.bottomBarNavigation.BottomNavGraph
import com.example.farmer.ui.theme.BlueJC
import com.example.farmer.ui.theme.PurpleGrey80

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun BottomNavBarPrev(){
//    BottomNavBar()
//}

@Composable
fun  BottomNavBar(rootNavController: NavHostController){
 val navController = rememberNavController()
    val bottomNavStartDestination = BottomBarRoutes.Home.route
    val context = LocalContext.current

    //Track current route instead of icon resource
    val currRoute = remember { mutableStateOf(BottomBarRoutes.Home.route) }

    //objesrve navigation changes
    navController.addOnDestinationChangedListener { _, destination, _ ->
        currRoute.value = destination.route ?: BottomBarRoutes.Home.route
    }
    Scaffold(
        bottomBar = {
            BottomAppBar(
            ) {
                Row (modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically){

                    NavItem(
                        iconRes = R.drawable.baseline_home_24,
                        label = "Home",
                        isSelected = currRoute.value == BottomBarRoutes.Home.route
                    ) {
                       if(currRoute.value != BottomBarRoutes.Home.route ){
                           navController.navigate(BottomBarRoutes.Home.route){
                               popUpTo(bottomNavStartDestination) {
                              //    saveState = true
                               }
                               launchSingleTop = true
                               //restoreState = true
                           }
                       }
                    }
                    NavItem(
                        iconRes = R.drawable.baseline_list_alt_24,
                        label = "Collections",
                        isSelected = currRoute.value == BottomBarRoutes.Collections.route
                    ) {
                        if (currRoute.value != BottomBarRoutes.Collections.route) {
                            navController.navigate(BottomBarRoutes.Collections.route) {
                                popUpTo(bottomNavStartDestination) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    NavItem(
                        iconRes = R.drawable.baseline_supervisor_account_24,
                        label ="Customers",
                        isSelected = currRoute.value == BottomBarRoutes.Customers.route
                    ) {
                        if (currRoute.value != BottomBarRoutes.Customers.route) {
                            navController.navigate(BottomBarRoutes.Customers.route) {
                                popUpTo(bottomNavStartDestination) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    NavItem(
                        iconRes = R.drawable.baseline_insert_chart_24,
                        label = "Reports",
                        isSelected = currRoute.value == BottomBarRoutes.Reports.route
                    ) {
                        if (currRoute.value != BottomBarRoutes.Reports.route) {
                            navController.navigate(BottomBarRoutes.Reports.route) {
                                popUpTo(bottomNavStartDestination) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    NavItem(iconRes = R.drawable.baseline_more_horiz_24,
                        label = "More",
                        isSelected = currRoute.value == BottomBarRoutes.More.route
                    ) {
                        if (currRoute.value != BottomBarRoutes.More.route) {
                            navController.navigate(BottomBarRoutes.More.route) {
                                popUpTo(bottomNavStartDestination) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                //restoreState = true
                            }
                        }
                    }
                }
            }
        }
    ) {paddingValue ->

       BottomNavGraph(navController = navController, rootNavController = rootNavController, paddingValues = paddingValue)
    }
}

@Composable
fun NavItem(
    @DrawableRes iconRes: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    // Shared interactionSource
    val noRipple = remember { MutableInteractionSource() }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
     //  modifier = Modifier.weight(1f)
    ) {
        IconButton(
            onClick = onClick , modifier = Modifier.width(60.dp).weight(1f).indication(interactionSource = noRipple,indication = null),
            colors =if(isSelected) IconButtonDefaults.iconButtonColors(
                containerColor = PurpleGrey80
            ) else IconButtonDefaults.iconButtonColors()

        ) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(30.dp).weight(1f),
                tint = if (isSelected) BlueJC else Color.DarkGray
            )

        }
        Text(modifier = Modifier.weight(1f),
            text = label,
            fontSize = 12.sp,
            color = if (isSelected) BlueJC else Color.DarkGray
        )

    }
}

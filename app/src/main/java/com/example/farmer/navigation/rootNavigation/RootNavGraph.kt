package com.example.farmer.navigation.rootNavigation

import BottomNavBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.farmer.features.Splash_feature.Splash
import com.example.farmer.navigation.bottomBarNavigation.BottomBarRoutes
import com.example.farmer.navigation.otherNavigation.OtherNavGraph

@Composable
fun RootNavGraph(rootNavController: NavHostController){

    NavHost(navController = rootNavController, startDestination = RootRoutes.Splash.route) {

        //Splash Screen
        composable(route = RootRoutes.Splash.route) {
            Splash(navigateHome = {rootNavController.navigate(RootRoutes.Main.route){popUpTo(
                RootRoutes.Splash.route){inclusive = true} } })
        }

        //BottomNavBar
        composable(route = RootRoutes.Main.route) {
            BottomNavBar(rootNavController = rootNavController)
        }

        ////Others
//        composable(route = RootRoutes.Intro.route) {  }
//        composable(route = RootRoutes.ChangePassword.route) {  }
//    composable(route = RootRoutes.EditProfile.route) {  }
//        composable(route = RootRoutes.Login.route) {  }
//        composable(route = RootRoutes.Register.route) {  }
//        composable(route = RootRoutes.ResetPassword.route){  }

        with(this){
            OtherNavGraph(rootNavController = rootNavController)
        }
    }


}

package com.example.farmer.navigation.bottomBarNavigation

sealed class BottomBarRoutes(val route: String){
    object Home: BottomBarRoutes("home")
    object Collections: BottomBarRoutes("collections")
    object Customers: BottomBarRoutes("customers")
    object More: BottomBarRoutes("more")
    object Reports: BottomBarRoutes("reports")

}
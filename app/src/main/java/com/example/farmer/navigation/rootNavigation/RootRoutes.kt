package com.example.farmer.navigation.rootNavigation

sealed class RootRoutes(val route: String){
    object Splash: RootRoutes("splash")
    object Main: RootRoutes("main")
}
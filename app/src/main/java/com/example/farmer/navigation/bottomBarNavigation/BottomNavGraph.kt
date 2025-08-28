package com.example.farmer.navigation.bottomBarNavigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.farmer.features.Collections_feature.presentation.screens.collections.CollectionsScreen
import com.example.farmer.features.Customers_feature.presentation.screens.CustomersScreen
import com.example.farmer.features.Home_feature.presentation.screens.HomeScreen
import com.example.farmer.features.More_feature.presentation.screens.MoreScreen
import com.example.farmer.features.ReportRows_feature.presentation.screens.ReportsScreen
import com.example.farmer.navigation.otherNavigation.OtherRoutes


@Composable
fun BottomNavGraph(navController: NavHostController , rootNavController: NavHostController,paddingValues: PaddingValues){

    NavHost(navController = navController, startDestination = BottomBarRoutes.Home.route) {

        //home
        composable(BottomBarRoutes.Home.route){ HomeScreen(paddingValues) }

       //collections
        composable(BottomBarRoutes.Collections.route){ CollectionsScreen(paddingValues,
            onAddNewCollectionClick = {
            rootNavController.navigate(OtherRoutes.AddNewCollection.route){
                launchSingleTop = true
                restoreState = true
            }
        }, onShiftReport = { rootNavController.navigate(OtherRoutes.ShiftReport.route){
                launchSingleTop = true
                restoreState = true
            }},
            onAbsentCustomers = { rootNavController.navigate(OtherRoutes.AbsentCustomers.route){
                launchSingleTop = true
                restoreState = true
            }}
        ) }

        //customers
        composable(BottomBarRoutes.Customers.route){ CustomersScreen(paddingValues,onAddCustomerClick = {
            rootNavController.navigate(OtherRoutes.AddNewCustomer.route){
                launchSingleTop = true
                restoreState = true
            }
        }, onBackClick = { rootNavController.navigateUp() }) }

        //reports
        composable(BottomBarRoutes.Reports.route){ ReportsScreen(paddingValues,
            onSalesReportClick = {rootNavController.navigate( OtherRoutes.SalesReport.route){
                launchSingleTop = true
                restoreState = true
            }},
            onShiftReportClick = { rootNavController.navigate(  OtherRoutes.ShiftReport.route){
                launchSingleTop = true
                restoreState = true
            }},
            onPaymentReportClick = { rootNavController.navigate(OtherRoutes.PaymentReport.route){
                launchSingleTop = true
                restoreState = true
            }},
            onCustomerReportClick = { rootNavController.navigate(OtherRoutes.Customer.route){
                launchSingleTop = true
                restoreState = true
            }},
            onPaymentRegisterClick = { rootNavController.navigate(OtherRoutes.PaymentRegister.route){
                launchSingleTop = true
                restoreState = true
            }},
            onCreditOrDebitReportClick = { rootNavController.navigate(OtherRoutes.CreditorDebitReport.route){
                launchSingleTop = true
                restoreState = true
            }},
            onPaymentAndSalesReportClick = { rootNavController.navigate(OtherRoutes.PaymentAndSalesReport.route){
                launchSingleTop = true
                restoreState = true
            }}
            ) }

        //more
        composable(BottomBarRoutes.More.route){ MoreScreen(paddingValues,
            onMilkSalesClick = { rootNavController.navigate(OtherRoutes.MilkSales.route){
                launchSingleTop = true
                restoreState = true
            } },
            onSalesClick = { rootNavController.navigate(OtherRoutes.Sales.route){
                launchSingleTop = true
                restoreState = true
            } },
            onVideoClick = {  rootNavController.navigate(OtherRoutes.Video.route){
                launchSingleTop = true
                restoreState = true
            }},
            onLogoutClick = { rootNavController.navigate(OtherRoutes.Logout.route){
                launchSingleTop = true
                restoreState = true
            }},
            onSettingClick = {  rootNavController.navigate(OtherRoutes.Settings.route){
                launchSingleTop = true
                restoreState = true
            }},
            onLanguageClick = { rootNavController.navigate(OtherRoutes.Language.route){
                launchSingleTop = true
                restoreState = true
            }},
            onProductsClick = { rootNavController.navigate(OtherRoutes.Products.route){
                launchSingleTop = true
                restoreState = true
            }},
            onSubscriptionClick = {  rootNavController.navigate(OtherRoutes.Subscription.route){
                launchSingleTop = true
                restoreState = true
            }},
            onContactUsClick = {  rootNavController.navigate(OtherRoutes.ContactUs.route){
                launchSingleTop = true
                restoreState = true
            }},
            onRateChartClick = { rootNavController.navigate(OtherRoutes.RateChart.route){
                launchSingleTop = true
                restoreState = true
            }},
            onRateThisAppClick = { rootNavController.navigate(OtherRoutes.RateThisApp.route){
                launchSingleTop = true
                restoreState = true
            }},
            onMemberPaymentClick = { rootNavController.navigate(OtherRoutes.MemberPayment.route){
                launchSingleTop = true
                restoreState = true
            }},
            onPersonalDetailsClick = { rootNavController.navigate(OtherRoutes.PersonalDetails.route){
                launchSingleTop = true
                restoreState = true
            }},
            onShareThisAppClick = { rootNavController.navigate(OtherRoutes.ShareThisApp.route){
                launchSingleTop = true
                restoreState = true
            }},
            onDairyInformationClick = { rootNavController.navigate(OtherRoutes.DairyInformation.route){
                launchSingleTop = true
                restoreState = true
            }},) }

    }



}
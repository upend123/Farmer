package com.example.farmer.navigation.otherNavigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.farmer.features.Collections_feature.presentation.screens.absentCostomers.AbsentCustomersScreen
import com.example.farmer.features.Collections_feature.presentation.screens.addNewCollection.AddNewCollectionScreen
import com.example.farmer.features.Customers_feature.presentation.screens.AddCustomer.AddCustomerScreen
import com.example.farmer.features.More_feature.presentation.screens.ContactUs.ContactUsScreen
import com.example.farmer.features.More_feature.presentation.screens.DairyInformation.DairyInformationScreen
import com.example.farmer.features.More_feature.presentation.screens.Language.LanguageScreen
import com.example.farmer.features.More_feature.presentation.screens.MemberPayments.AddNewMemberPaymentScreen
import com.example.farmer.features.More_feature.presentation.screens.MemberPayments.MemberPaymentsScreen
import com.example.farmer.features.More_feature.presentation.screens.MilkSales.AddNewMilkSalesScreen
import com.example.farmer.features.More_feature.presentation.screens.MilkSales.MilkSalesScreen
import com.example.farmer.features.More_feature.presentation.screens.PersonalDetails.PersonaDetailsScreen
import com.example.farmer.features.More_feature.presentation.screens.Products.AddNewProductScreen
import com.example.farmer.features.More_feature.presentation.screens.Products.ProductsScreen
import com.example.farmer.features.More_feature.presentation.screens.RateChart.RateChartScreen
import com.example.farmer.features.More_feature.presentation.screens.Sales.NewSalesScreen
import com.example.farmer.features.More_feature.presentation.screens.Sales.SalesScreen
import com.example.farmer.features.More_feature.presentation.screens.Settings.SettingsScreen
import com.example.farmer.features.More_feature.presentation.screens.Subscription.SubscriptionScreen
import com.example.farmer.features.Reports_feature.presentation.screens.CreditOrDebitReports.CreditorDebitReportsScreen
import com.example.farmer.features.Reports_feature.presentation.screens.Customers.CustomersReport
import com.example.farmer.features.Reports_feature.presentation.screens.PaymentAndRegister.PaymentRegisterScreen
import com.example.farmer.features.Reports_feature.presentation.screens.PaymentAndSales.PaymentAndSalesReportScreen
import com.example.farmer.features.Reports_feature.presentation.screens.PaymentReport.PaymentReportScreen
import com.example.farmer.features.Reports_feature.presentation.screens.SalesReport.SalesReportScreen
import com.example.farmer.features.Reports_feature.presentation.screens.ShiftReport.ShiftReportScreen


fun NavGraphBuilder.OtherNavGraph(rootNavController: NavHostController){

    //Collections item screens
        //AddNewCollection
        composable(OtherRoutes.AddNewCollection.route) {
            AddNewCollectionScreen(onBackClick = {
                rootNavController.navigateUp()
            })
        }
    //Absent Customers
        composable(OtherRoutes.AbsentCustomers.route) {
            AbsentCustomersScreen(onBackClick = {
                rootNavController.navigateUp()
            })
        }



    //More item screens
     //Milk Sales
     composable(OtherRoutes.MilkSales.route) {
        MilkSalesScreen(onAddClick = { rootNavController.navigate(OtherRoutes.AddMilkSales.route){
            launchSingleTop = true
            restoreState = true
        }}, onBackClick = { rootNavController.navigateUp()})
        }
    composable(OtherRoutes.AddMilkSales.route){
        AddNewMilkSalesScreen(onAddClick = {} , onBackClick = {
            rootNavController.navigateUp()
        })
    }
      composable(OtherRoutes.Sales.route) {
         SalesScreen(onBackClick = { rootNavController.navigateUp()}, onAddNewSalesClick = { rootNavController.navigate(
             OtherRoutes.NewSales.route){
             launchSingleTop = true
             restoreState = true
         }})
        }
    composable(OtherRoutes.NewSales.route) {
        NewSalesScreen(onAddProduct = {
            rootNavController.navigate(OtherRoutes.AddNewProduct.route){
                launchSingleTop = true
                restoreState = true
            }
        }, onBackClick = {rootNavController.navigateUp()})
        }
      composable(OtherRoutes.MemberPayment.route) {
         MemberPaymentsScreen(onBackClick = {rootNavController.navigateUp()},
             onAddNewMemberPayment = { rootNavController.navigate(OtherRoutes.AddNewMemberPayment.route){
                 launchSingleTop = true
                 restoreState = true
             }})
        }
    composable(OtherRoutes.AddNewMemberPayment.route) {
        AddNewMemberPaymentScreen(onBackClick = { rootNavController.navigateUp()})
    }
      composable(OtherRoutes.DairyInformation.route) {
         DairyInformationScreen(onBackClick = {
             rootNavController.navigateUp()
         })
        }
      composable(OtherRoutes.Settings.route) {
          SettingsScreen(onBackClick = {
              rootNavController.navigateUp()
          })
        }
      composable(OtherRoutes.RateChart.route) {
         RateChartScreen(
             onBackClick = {
                 rootNavController.navigateUp()
             }
         )
        }
      composable(OtherRoutes.Products.route) {
          ProductsScreen(
              onBackClick = {
                  rootNavController.navigateUp()
              },
              onAddProductClick = {
                  rootNavController.navigate(OtherRoutes.AddNewProduct.route){
                      launchSingleTop = true
                      restoreState = true
                  }
              }
          )
        }
composable(OtherRoutes.AddNewProduct.route) {
    AddNewProductScreen(onBackClick = { rootNavController.navigateUp()})
        }
    composable(OtherRoutes.Subscription.route) {
        SubscriptionScreen(
            onBackClick = {
                rootNavController.navigateUp()
            }
        )
    }
      composable(OtherRoutes.PersonalDetails.route) {
         PersonaDetailsScreen( onBackClick = {
             rootNavController.navigateUp()
         },
             onPersonalDetailClick = {
                 rootNavController.navigate(OtherRoutes.PersonalDetails.route){
                     launchSingleTop = true
                     restoreState = true
                 }
             },
             onDeleteAccountClick = {

             })
        }
      composable(OtherRoutes.Language.route) {
         LanguageScreen()
        }
    composable(OtherRoutes.ContactUs.route) {
         ContactUsScreen(
             onBackClick = {
                 rootNavController.navigateUp()
             }
         )
        }
    composable(OtherRoutes.Video.route) {
        PersonaDetailsScreen()
    }
     composable(OtherRoutes.RateThisApp.route) {
         PersonaDetailsScreen()
        }
     composable(OtherRoutes.ShareThisApp.route) {
         PersonaDetailsScreen()
        }
     composable(OtherRoutes.Logout.route) {
         PersonaDetailsScreen()
        }

    //Report item Screens
    composable(OtherRoutes.PaymentAndSalesReport.route){PaymentAndSalesReportScreen(onBackClick = {rootNavController.navigateUp()})}
    composable(OtherRoutes.SalesReport.route){ SalesReportScreen(onBackClick = {rootNavController.navigateUp()}) }
    composable(OtherRoutes.ShiftReport.route){ ShiftReportScreen(onBackClick = { rootNavController.navigateUp()}) }
    composable(OtherRoutes.PaymentReport.route){ PaymentReportScreen(onBackClick = {rootNavController.navigateUp()}) }
    composable(OtherRoutes.Customer.route){
        CustomersReport(onBackClick = {
            rootNavController.navigateUp()
        })
    }
    //AddNewCustomer
    composable(OtherRoutes.AddNewCustomer.route) {
        AddCustomerScreen(onBackClick = {rootNavController.navigateUp()})
    }
    composable(OtherRoutes.PaymentRegister.route){ PaymentRegisterScreen( onBackClick = { rootNavController.navigateUp()}) }
    composable(OtherRoutes.CreditorDebitReport.route){ CreditorDebitReportsScreen(onBackClick = { rootNavController.navigateUp()}) }

    }


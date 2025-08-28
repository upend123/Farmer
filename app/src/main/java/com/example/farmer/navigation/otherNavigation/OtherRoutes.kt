package com.example.farmer.navigation.otherNavigation

sealed class OtherRoutes(val route: String){
    //Collections Routes
    object AddNewCollection: OtherRoutes("add_new_collection")
    object AddNewCustomer: OtherRoutes("add_new_customer")
    object AbsentCustomers: OtherRoutes("absent_customers")


    //More Routes
    object MilkSales: OtherRoutes("milk_sales")
    object AddMilkSales : OtherRoutes("add_milk_sales")

    object Sales: OtherRoutes("sales")
    object NewSales: OtherRoutes("new_sales")

    object MemberPayment: OtherRoutes("member_payment")
    object AddNewMemberPayment : OtherRoutes("add_new_member_payment")

    object DairyInformation: OtherRoutes("dairy_information")
    object RateChart: OtherRoutes("rate_chart")

    object Products: OtherRoutes("products")
    object AddNewProduct: OtherRoutes("add_new_product")

    object Subscription: OtherRoutes("subscription")
    object PersonalDetails: OtherRoutes("personal_details")
    object Language: OtherRoutes("language")
    object Video: OtherRoutes("video")
    object ContactUs: OtherRoutes("contacts_us")
    object RateThisApp: OtherRoutes("rate_this_app")
    object ShareThisApp: OtherRoutes("share_this_app")
    object Logout: OtherRoutes("logout")
    object Settings: OtherRoutes("settings")


    //Reports Routes
    object ShiftReport: OtherRoutes("shift_report")
    object PaymentReport: OtherRoutes("payment_report")
    object PaymentRegister: OtherRoutes("payment_register")
    object CreditorDebitReport: OtherRoutes("credit/debit_report")
    object SalesReport: OtherRoutes("sales_report")
    object PaymentAndSalesReport: OtherRoutes("payment&sales_report")
    object Customer: OtherRoutes("customer_report")



}
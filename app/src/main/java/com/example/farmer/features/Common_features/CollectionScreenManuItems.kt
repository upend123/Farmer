package com.example.farmer.features.Common_features

import com.example.farmer.R

enum class CollectionScreenManuItems(val title : String,val icon: Int) {
    Absent( "Absent Customers",R.drawable.baseline_supervised_user_circle_24,),
    Search("Search",R.drawable.baseline_person_search_24),
    ShiftReport("Shift Report",R.drawable.baseline_nights_stay_24),
    SortByCode("Sort: By Code",R.drawable.baseline_sort_by_alpha_24),
    SortByTime("Sort: By Time",R.drawable.baseline_access_time_24),
    ReconnectPrinter("Reconnect Printer",R.drawable.baseline_print_24)
}


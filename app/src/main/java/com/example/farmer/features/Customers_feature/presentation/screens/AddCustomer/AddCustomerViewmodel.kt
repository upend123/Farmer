package com.example.farmer.features.Customers_feature.presentation.screens.AddCustomer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmer.features.Customers_feature.data.local.entity.CustomerEntity
import kotlinx.coroutines.launch


class AddCustomerViewmodel : ViewModel()  {

    fun upsertCustomer(customerEntity: CustomerEntity){
viewModelScope.launch {

}

    }

}
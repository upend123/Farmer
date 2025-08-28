package com.example.farmer.features.Customers_feature.data.local.db

import com.example.farmer.features.Customers_feature.data.local.dao.CustomerDao
import com.example.farmer.features.Customers_feature.data.local.entity.CustomerEntity
import kotlinx.coroutines.flow.onEach

class CustomerDBRepo(private val dao : CustomerDao) {


    suspend fun upsertCustomer(customerEntity: CustomerEntity){
        dao.upsertCustomer(customerEntity)
    }

    suspend fun deleteCustomer(customerEntity: CustomerEntity){
        dao.deleteCustomer(customerEntity)
    }

    suspend fun  deleteCustomerById(id: Int){
        dao.deleteCustomerById(id)
    }

    suspend fun  getCustomerById(id: Int){
        dao.getCustomerById(id)
    }

    fun getAllCustomer() =dao.getAllCustomers().onEach { customer ->  }

}


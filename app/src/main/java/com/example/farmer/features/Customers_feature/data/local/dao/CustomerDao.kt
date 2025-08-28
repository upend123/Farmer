package com.example.farmer.features.Customers_feature.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmer.features.Customers_feature.data.local.entity.CustomerEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface CustomerDao {

    @Upsert
    suspend fun upsertCustomer(customerEntity: CustomerEntity)

    @Delete
    suspend fun deleteCustomer(customerEntity: CustomerEntity)

    @Query("DELETE FROM `customer_entity` WHERE code = :id")
    suspend fun deleteCustomerById(id: Int)

    @Query("SELECT * FROM `customer_entity` WHERE code = :id")
    suspend fun getCustomerById(id: Int)

    @Query("SELECT * FROM `customer_entity`")
    fun getAllCustomers() : Flow<List<CustomerEntity>>

}
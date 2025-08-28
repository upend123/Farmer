package com.example.farmer.features.Customers_feature.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "customer_entity")
data class CustomerEntity(

    @PrimaryKey(autoGenerate = true)
    val code: Int = 0,
    val name : String,
    val mobileNumber: String,

)
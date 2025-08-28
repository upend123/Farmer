package com.example.farmer.features.Customers_feature.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.farmer.features.Customers_feature.data.local.dao.CustomerDao
import com.example.farmer.features.Customers_feature.data.local.entity.CustomerEntity


@Database(entities = [CustomerEntity::class], version = 1, exportSchema = false)
abstract class CustomerDatabase : RoomDatabase() {
    abstract fun dao(): CustomerDao
}
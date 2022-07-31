package com.example.ewalle.domain

import com.example.ewalle.data.DataRepository
import com.example.ewalle.data.SimpleDataSource
import com.example.ewalle.data.model.AccInfo
import com.example.ewalle.data.model.Contact
import com.example.ewalle.data.model.Service
import javax.inject.Inject

class DataRepoImpl @Inject constructor(private val dataSource: SimpleDataSource) : DataRepository {
    override fun getServices(): List<Service> {
        return dataSource.getServices()
    }

    override fun getContacts(): List<Contact> {
        return dataSource.getContacts()
    }

    override fun getAccountInfo(): AccInfo {
        return dataSource.getAccountInfo()
    }
}
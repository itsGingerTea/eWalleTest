package com.example.ewalle.data

import com.example.ewalle.data.model.AccInfo
import com.example.ewalle.data.model.Contact
import com.example.ewalle.data.model.Service

interface DataRepository {
    fun getServices(): List<Service>
    fun getContacts(): List<Contact>
    fun getAccountInfo(): AccInfo
}
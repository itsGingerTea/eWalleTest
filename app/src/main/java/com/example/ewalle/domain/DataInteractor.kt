package com.example.ewalle.domain

import com.example.ewalle.data.DataRepository
import com.example.ewalle.data.model.AccInfo
import com.example.ewalle.data.model.Contact
import com.example.ewalle.data.model.Service
import javax.inject.Inject

class DataInteractor @Inject constructor(private val dataRepository: DataRepository) {
    fun getContacts(): List<Contact> {
        return dataRepository.getContacts()
    }

    fun getServices(): List<Service> {
        return dataRepository.getServices()
    }

    fun getAccountInfo(): AccInfo {
        return dataRepository.getAccountInfo()
    }
}
package com.example.ewalle.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ewalle.data.model.AccInfo
import com.example.ewalle.data.model.Contact
import com.example.ewalle.data.model.Service
import com.example.ewalle.domain.DataInteractor
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val interactor: DataInteractor) : ViewModel() {

    private val _listServices = MutableLiveData<List<Service>>()
    val services: LiveData<List<Service>> get() = _listServices
    private val _listContacts = MutableLiveData<List<Contact>>()
    val contacts: LiveData<List<Contact>> get() = _listContacts
    private val _accInfo = MutableLiveData<AccInfo>()
    val accInfo: LiveData<AccInfo> get() = _accInfo


    fun onViewCreated() {
        val services = interactor.getServices()
        val contacts = interactor.getContacts()
        val accinfo = interactor.getAccountInfo()
        _listServices.postValue(services)
        _listContacts.postValue(contacts)
        _accInfo.postValue(accinfo)
    }
}
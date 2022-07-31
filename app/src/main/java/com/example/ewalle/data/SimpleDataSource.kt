package com.example.ewalle.data

import com.example.ewalle.R
import com.example.ewalle.data.model.AccInfo
import com.example.ewalle.data.model.Contact
import com.example.ewalle.data.model.Service

class SimpleDataSource {
    private val servicesList = listOf<Service>(
        Service(
            1,
            R.string.send_money,
            R.drawable.send
        ),
        Service(
            2,
            R.string.receive_money,
            R.drawable.recei
        ),
        Service(3, R.string.mobile_prepaid, R.drawable.mob),
        Service(
            4,
            R.string.electricity_bill,
            R.drawable.ele
        ),
        Service(
            5,
            R.string.cashback_offer,
            R.drawable.cash
        ),
        Service(6, R.string.movie_tickets, R.drawable.mov),
        Service(7, R.string.flight_tick, R.drawable.fly),
        Service(8, R.string.more_options, R.drawable.more),
    )
    private val contactsList = listOf<Contact>(
        Contact(
            1,
            R.string.contact_mike,
            R.drawable.boy_list
        ),
        Contact(
            2,
            R.string.contact_joshpeh,
            R.drawable.man_list
        ),
        Contact(
            3,
            R.string.contact_ashley,
            R.drawable.woman_list
        ),
        Contact(
            4,
            R.string.contact_maya,
            R.drawable.girl_list
        ),
    )
    private val accInfo = AccInfo(600230.0)

    fun getServices(): List<Service> {
        return servicesList
    }

    fun getContacts(): List<Contact> {
        return contactsList
    }

    fun getAccountInfo(): AccInfo {
        return accInfo
    }
}
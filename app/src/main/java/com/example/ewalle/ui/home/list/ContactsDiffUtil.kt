package com.example.ewalle.ui.home.list

import androidx.recyclerview.widget.DiffUtil
import com.example.ewalle.data.model.Contact

object ContactsDiffUtil : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }
}
package com.example.ewalle.ui.home.list

import androidx.recyclerview.widget.DiffUtil
import com.example.ewalle.data.model.Service

object ServicesDiffUtil : DiffUtil.ItemCallback<Service>() {
    override fun areItemsTheSame(oldItem: Service, newItem: Service): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Service, newItem: Service): Boolean {
        return oldItem == newItem
    }
}
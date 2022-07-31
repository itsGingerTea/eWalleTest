package com.example.ewalle.ui.home.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ewalle.data.model.Service
import com.example.ewalle.databinding.RvItemServicesBinding

class ServicesAdapter : ListAdapter<Service, ServicesAdapter.ServiceViewHolder>(ServicesDiffUtil) {

    inner class ServiceViewHolder(private val item: RvItemServicesBinding) :
        RecyclerView.ViewHolder(item.root) {
        fun bind(service: Service) {
            with(item) {
                tvItemServices.text = item.root.context.getString(service.name)
                ivItemServices.setImageDrawable(
                    AppCompatResources.getDrawable(
                        item.root.context,
                        service.src
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder =
        ServiceViewHolder(
            item = RvItemServicesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
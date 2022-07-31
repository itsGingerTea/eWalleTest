package com.example.ewalle.ui.home.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ewalle.data.model.Contact
import com.example.ewalle.databinding.RvItemContactsBinding

class ContactsAdapter : ListAdapter<Contact, ContactsAdapter.ContactViewHolder>(ContactsDiffUtil) {
    inner class ContactViewHolder(private val item: RvItemContactsBinding) :
        RecyclerView.ViewHolder(item.root) {
        fun bind(contact: Contact) {
            with(item) {
                tvContactName.text = root.context.getString(contact.name)
                Glide
                    .with(root.context)
                    .load(contact.src)
                    .into(ivContactAvatar)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder =
        ContactViewHolder(
            item = RvItemContactsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
package com.trinitywizards.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.trinitywizards.viewModel.MainViewModel
import com.trinitywizards.data.Contact
import com.trinitywizards.test.R
import com.trinitywizards.test.databinding.ItemContactBinding
import com.trinitywizards.utils.BindableAdapter
import org.koin.core.KoinComponent

class ContactAdapter (private val mainViewModel: MainViewModel, private val context: Context) :
    RecyclerView.Adapter<ContactAdapter.PastJobViewHolder>(),
    KoinComponent,
    BindableAdapter<Contact> {

    private var contactList: List<Contact> = emptyList()

    override fun setData(items: List<Contact>) {
        contactList = items
    }

    override fun refreshData() {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastJobViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemContactBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_contact, parent, false)
        binding.viewModel = mainViewModel
        return PastJobViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: PastJobViewHolder, position: Int) {
        holder.bind(contactList[position])
    }

    inner class PastJobViewHolder(private val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {

            binding.contact = contact
        }
    }

}
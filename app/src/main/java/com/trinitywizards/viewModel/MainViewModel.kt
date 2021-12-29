package com.trinitywizards.viewModel

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.trinitywizards.data.Contact
import com.trinitywizards.ui.AddUpdateContactActivity
import org.koin.core.KoinComponent

class MainViewModel (): ViewModel(), KoinComponent{

    val contactList: ArrayList<Contact> = arrayListOf()

    fun onContactClick(contact: Contact, context: Context){
        val addUpdateContactActivity = Intent(context, AddUpdateContactActivity::class.java)
        addUpdateContactActivity.putExtra("contact", contact)
        context.startActivity(addUpdateContactActivity)
    }

}
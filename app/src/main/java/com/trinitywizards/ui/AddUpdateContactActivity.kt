package com.trinitywizards.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.trinitywizards.data.Contact
import com.trinitywizards.test.R
import com.trinitywizards.test.databinding.ActivityAddUpdateContactBinding
import com.trinitywizards.viewModel.AddUpdateContactViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class AddUpdateContactActivity : AppCompatActivity() {
    private val addUpdateContactViewModel by viewModel<AddUpdateContactViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityAddUpdateContactBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_add_update_contact
        )

        binding.viewModel = addUpdateContactViewModel
        binding.lifecycleOwner = this
        binding.contact = intent.extras?.get("contact") as Contact

    }
}
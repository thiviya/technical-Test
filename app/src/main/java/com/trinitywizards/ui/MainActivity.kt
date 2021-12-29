package com.trinitywizards.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.trinitywizards.test.R
import com.trinitywizards.test.databinding.ActivityMainBinding
import com.trinitywizards.viewModel.MainViewModel
import com.trinitywizards.data.Contact
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import org.koin.android.viewmodel.ext.android.viewModel
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this

        contactRecyclerView.layoutManager = LinearLayoutManager(this)
        contactRecyclerView.adapter = ContactAdapter(mainViewModel, this)
        contactRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        try {
            val jsonObject = JSONObject(jsonDataFromAsset())
            val jsonArray = jsonObject.getJSONArray(("contacts"))
            for(i in 0..jsonArray.length()){
                val json = jsonArray.getJSONObject(i)
                val contact = Contact(json.optString("id"), json.optString("firstName"), json.optString("lastName"), json.optString("email"), json.optString("phone"))
                mainViewModel.contactList.add(contact)
            }



        }catch (e:JSONException){
            e.printStackTrace()
        }

    }

    fun jsonDataFromAsset(): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = assets.open("contacts.json")
            val sizeOfFile = inputStream.available()
            val bufferData = ByteArray(sizeOfFile)
            inputStream.read(bufferData)
            inputStream.close()
            json = String(bufferData)
        }catch (e: Exception){
            e.printStackTrace()
            return null
        }
        return json
    }
}
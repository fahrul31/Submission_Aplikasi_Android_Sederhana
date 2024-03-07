package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.ListDestinationAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Destination
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rvDestinations : RecyclerView
    private lateinit var fabAboutPage : FloatingActionButton
    private lateinit var binding: ActivityMainBinding

    private val list = ArrayList<Destination>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvDestinations = binding.rvDestinations
        rvDestinations.setHasFixedSize(true)
        fabAboutPage = binding.aboutPage

        fabAboutPage.setOnClickListener{
            val intent = Intent(this@MainActivity, AboutUsActivity::class.java)
            startActivity(intent)
        }

        list.addAll(getListDestinations())
        showRecyclerList()
    }

    private fun getListDestinations(): Collection<Destination> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataAddress = resources.getStringArray(R.array.data_address)
        val dataOpen = resources.getStringArray(R.array.data_opening_hours)
        val listDestinations = ArrayList<Destination>()
        for (i in dataName.indices){
            val destination = Destination(dataName[i], dataDescription[i], dataPhoto[i], dataAddress[i], dataOpen[i])
            listDestinations.add(destination)
        }
        return listDestinations
    }

    private fun showRecyclerList() {
        rvDestinations.layoutManager = LinearLayoutManager(this)
        val listDestinationAdapter = ListDestinationAdapter(list, onClick = {
            val destinationResultIntent = Intent(this@MainActivity, DetailDestinationActivity::class.java)
            destinationResultIntent.putExtra("DESTINATION", it)
            startActivity(destinationResultIntent)
        })
        rvDestinations.adapter = listDestinationAdapter
    }
}
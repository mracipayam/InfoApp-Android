package com.mracipayam.infoappsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.mracipayam.infoappsample.databinding.ActivityDetailsBinding
import com.mracipayam.infoappsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList : ArrayList<Landmark>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()

        //Data
        val musician = Landmark("Musician","Turkey",R.drawable.music)
        val coffee = Landmark("Turkish Tea","Turkiye",R.drawable.coffee)
        val nevsehir = Landmark("Nevsehir","Turkey",R.drawable.baloonone)
        val baloon = Landmark("Balloons","Turkey Nevsehir",R.drawable.baloontwo)

        landmarkList.add(musician)
        landmarkList.add(coffee)
        landmarkList.add(nevsehir)
        landmarkList.add(baloon)

        //Adapter and Layout
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map { landmark -> landmark.name  })
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(MainActivity@this,DetailsActivity::class.java)
            intent.putExtra("landmark",landmarkList.get(position));
            startActivity(intent)
        }
    }
}
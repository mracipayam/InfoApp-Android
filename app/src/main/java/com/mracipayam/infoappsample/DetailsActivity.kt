package com.mracipayam.infoappsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mracipayam.infoappsample.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val SelectedLandmark = intent.getSerializableExtra("landmark") as Landmark

        binding.nameText.text = SelectedLandmark.name
        binding.countryText.text = SelectedLandmark.country
        binding.imageView.setImageResource(SelectedLandmark.image)




    }
}
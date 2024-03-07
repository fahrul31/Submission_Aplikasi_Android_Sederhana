package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityDetailDestinationBinding
import com.example.myapplication.model.Destination

class DetailDestinationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDestinationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Destination>("DESTINATION")

        if (data != null){
            Glide.with(this).load(data.photo).into(binding.imageDestination)
            binding.textTitleDestination.text = data.name
            binding.textDescription.text = data.description
            binding.textAddress.text = data.address
            binding.textOpen.text = data.open_hours
            binding.buttonShare.setOnClickListener{
                val share = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, data.description)

                    // (Optional) Here you're setting the title of the content
                    putExtra(Intent.EXTRA_TITLE, data.name)
                    type = "text/plain"
                }
                startActivity(share)
            }
        }
    }
}
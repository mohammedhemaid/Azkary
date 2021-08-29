package com.app.durdling.azkar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.durdling.azkar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val azkarAdapter = AzkarAdapter()
        binding.azkarList.adapter = azkarAdapter
        azkarAdapter.submitList(DataSet.listOfAzkar)
    }
}
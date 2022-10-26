package com.example.testcleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.testcleanarchitecture.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.receiveButton.setOnClickListener {
            viewModel.load()

        }

        viewModel.resultLive.observe(this, Observer {
            binding.dataTextView.text = it
        })

        binding.sendButton.setOnClickListener {
            viewModel.save(binding.dataEditText.text.toString())

        }


    }
}
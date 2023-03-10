package com.geektech.android3dop1.acticity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.geektech.android3dop1.R
import com.geektech.android3dop1.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupObserves()
        setupListeners()
    }

    private fun setupObserves() {
        viewModel?.number?.observe(this) {
            binding.tvInt.text = it.toString()
        }
    }

    private fun setupListeners() {
        binding.btnPlus.setOnClickListener {
            viewModel?.setPlus()
            if (viewModel?.count!! >= 10 || viewModel?.count!! <= -10) {
                binding.tvInt.setTextColor(resources.getColor(R.color.purple_200))
            } else {
                binding.tvInt.setTextColor(resources.getColor(R.color.teal_200))
            }
        }
        binding.btnMinus.setOnClickListener {
            viewModel?.setMinus()

            if (viewModel?.count!! <= -10 || viewModel?.count!! >= 10) {
                binding.tvInt.setTextColor(resources.getColor(R.color.purple_200))
            } else {
                binding.tvInt.setTextColor(resources.getColor(R.color.teal_200))
            }
        }
    }
}

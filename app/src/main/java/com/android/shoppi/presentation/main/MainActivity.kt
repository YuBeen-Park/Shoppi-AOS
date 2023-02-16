package com.android.shoppi.presentation.main

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.shoppi.R
import com.android.shoppi.databinding.ActivityMainBinding
import com.android.shoppi.util.binding.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        binding.bnvMain.itemIconTintList = null
        val navController =
            supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            binding.bnvMain.setupWithNavController(it)
        }
    }
}
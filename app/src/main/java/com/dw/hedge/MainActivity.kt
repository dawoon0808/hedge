package com.dw.hedge

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dw.hedge.databinding.ActivityMainBinding
import com.dw.hedge.main.TapAdapterMain
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val adapter = TapAdapterMain(this)

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tapLayout,binding.viewPager){tab,position ->
            tab.text = when(position){
                0 -> "홈"
                1 -> "목록"
                else -> ".."
            }
        }.attach()


    }
}
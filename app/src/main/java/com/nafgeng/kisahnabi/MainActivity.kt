package com.nafgeng.kisahnabi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nafgeng.kisahnabi.adapter.TabAdapter
import com.nafgeng.kisahnabi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = TabAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab,position ->
            when (position) {
                0 -> {
                    tab.text = "Nabi"
                }
                1 -> {
                    tab.text = "Rasul"
                }
            }
        }.attach()
    }
}
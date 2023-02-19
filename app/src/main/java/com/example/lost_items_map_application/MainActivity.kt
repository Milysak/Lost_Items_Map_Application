package com.example.lost_items_map_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity(), mInterface {
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        viewPager = findViewById(R.id.viewPager)

        viewPager.adapter = ViewPagerAdapter(this)
    }

    override fun onBackPressed() {
        // Do nothing...
    }

    override fun update(state: Boolean) {
        viewPager.isUserInputEnabled = state
    }
}

interface mInterface {
    fun update(state: Boolean)
}
package com.example.lost_items_map_application

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapterMainApplication(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> { ProfileFragment() }
            1 -> { MapsFragment() }
            else -> { throw Resources.NotFoundException("Position Not Found") }
        }
    }
}
package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework1.fragment.FriendsListFragment

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2  // 增加更多的 Tab 可以在这里修改

    override fun createFragment(position: Int): Fragment {
        return FriendsListFragment()
    }
}

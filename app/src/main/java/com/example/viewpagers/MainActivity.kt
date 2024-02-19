package com.example.viewpagers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagers.databinding.ActivityMainBinding
import com.example.viewpagers.databinding.FragmentGeneralInfoBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.pager.adapter = PagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position -> // names the tabs (takes the TabLayout, the ViewPager2, and a lambda function as parameters.)
            when(position){
                0 -> tab.text = "Password"
                1 -> tab.text = "General Info"
            }
        }.attach() // connects the fragments with corresponding tab
    }

    //provide the fragments to be displayed within the ViewPager2.
    private inner class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        //specifies the total number of fragments
        override fun getItemCount(): Int = 2

        //instantiate the fragment for the given position
        override fun createFragment(position: Int): Fragment = when(position){
            0 -> PasswordsFragment()
            else -> GeneralInfoFragment()
        }
    }
}
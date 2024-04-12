package com.kuchumof.fortailoring

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.kuchumof.fortailoring.databinding.ActivityMainBinding
import com.kuchumof.fortailoring.fragments.order.FragmentOrder
import com.kuchumof.fortailoring.fragments.profile.FragmentProfile
import com.kuchumof.fortailoring.fragments.settings.FragmentSettings
import com.kuchumof.fortailoring.fragments.example_of_works.FragmentWorkExample


class MainActivity : AppCompatActivity() {

    private val fragmentOrder = FragmentOrder()
    private val fragmentProfile = FragmentProfile()
    private val fragmentSettings = FragmentSettings()
    private val fragmentWorkExample = FragmentWorkExample()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavigationViewListener()

        binding.bNavMenu.selectedItemId = R.id.fragmentOrders

    }


    private fun setBottomNavigationViewListener() {

        binding.bNavMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragmentOrders -> {
                    val fragmentTransaction: FragmentTransaction =
                        supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.content, fragmentOrder, "")
                    fragmentTransaction.commit()
                    true
                }

                R.id.fragmentWorkExamples -> {
                    val fragmentTransaction: FragmentTransaction =
                        supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.content, fragmentWorkExample, "")
                    fragmentTransaction.commit()
                    true
                }

                R.id.fragmentProfile -> {
                    val fragmentTransaction: FragmentTransaction =
                        supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.content, fragmentProfile, "")
                    fragmentTransaction.commit()
                    true
                }

                R.id.fragmentSettings -> {
                    val fragmentTransaction: FragmentTransaction =
                        supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.content, fragmentSettings, "")
                    fragmentTransaction.commit()
                    true
                }

                else -> false
            }
        }
    }
}
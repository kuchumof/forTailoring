package com.example.fortailoring.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import com.example.fortailoring.R
import com.example.fortailoring.databinding.ActivityMainBinding
import com.example.fortailoring.fragments.FragmentManager
import com.example.fortailoring.fragments.ItemOrderFragment
import com.example.fortailoring.fragments.ProfileFragment
import com.example.fortailoring.fragments.WorkExampleFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavListener()

    }

    /*
    * Отрисовка BottomNavigationView
    */
    private fun setBottomNavListener() {
        // фрагмент по умолчанию
        binding.bNavView.selectedItemId = R.id.my_profile_button

        //слушатель нажатий
        binding.bNavView.setOnItemSelectedListener {
            //определение нажатой кнопки
            when (it.itemId) {
                //действие по кнопке
                R.id.create_an_order_button -> {
                    FragmentManager.setFragment(ItemOrderFragment.newInstance(), this)
                    Log.d("MyLog", "create_an_order")
                }
                //действие по кнопке
                R.id.work_examples_button -> {
                    FragmentManager.setFragment(WorkExampleFragment.newInstance(), this)
                    Log.d("MyLog", "work_examples")
                }
                //действие по кнопке
                R.id.my_profile_button -> {
                    FragmentManager.setFragment(ProfileFragment.newInstance(), this)
                    Log.d("MyLog", "my_profile")
                }
                //действие по кнопке
                R.id.more_button -> {
                    Log.d("MyLog", "more")
                }
            }
            true
        }
    }

}
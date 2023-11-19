package com.example.fortailoring.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fortailoring.R
import com.example.fortailoring.databinding.ActivityMainBinding
import com.example.fortailoring.fragments.ItemOrderFragment
import com.example.fortailoring.fragments.ProfilFragment

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
        // активити по умолчанию
        binding.bNavView.selectedItemId = R.id.my_profile_button

        //слушатель нажатий
        binding.bNavView.setOnItemSelectedListener {
            //определение нажатой кнопки
            when (it.itemId) {
                //действие по кнопке
                R.id.create_an_order_button -> {
                    openFragment(ItemOrderFragment())
                    Log.d("MyLog", "create_an_order")
                    Toast.makeText(this, "Создать заказ", Toast.LENGTH_SHORT).show()
                }
                //действие по кнопке
                R.id.work_examples_button -> {
                    Log.d("MyLog", "work_examples")
                    Toast.makeText(this, "Примеры работ", Toast.LENGTH_SHORT).show()
                }
                //действие по кнопке
                R.id.my_profile_button -> {
                    openFragment(ProfilFragment())
                    Log.d("MyLog", "my_profile")
                    Toast.makeText(this, "Профиль", Toast.LENGTH_SHORT).show()
                }
                //действие по кнопке
                R.id.more_button -> {
                    Log.d("MyLog", "more")
                    Toast.makeText(this, "Ещё", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    private fun openFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.placeHolder, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}
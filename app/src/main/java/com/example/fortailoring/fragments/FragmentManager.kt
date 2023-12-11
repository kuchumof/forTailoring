package com.example.fortailoring.fragments

import androidx.appcompat.app.AppCompatActivity
import com.example.fortailoring.R

/**для работы с фрагментами*/
object FragmentManager {

    var currentFragment: BaseFragment? = null

    /**функция для переключения фрагментов*/
    fun setFragment(newFragment: BaseFragment, activity: AppCompatActivity) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeHolder, newFragment)
        transaction.commit() // применить изменения
        currentFragment = newFragment

    }

}
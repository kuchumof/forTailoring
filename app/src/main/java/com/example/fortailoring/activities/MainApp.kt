package com.example.fortailoring.activities

import android.app.Application
import com.example.fortailoring.db.MainDataBase

class MainApp : Application() {
    val database by lazy {
        MainDataBase.getDataBase(this)
    }
}
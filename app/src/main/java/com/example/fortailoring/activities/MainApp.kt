package com.example.fortailoring.activities

import android.app.Application
import com.example.fortailoring.db.MainDataBase

class MainApp : Application() {
    //создание инстанции(инициализация) БД на уровне всего приложения, для получения доступа из любого activity
    val database by lazy {
        MainDataBase.getDataBase(this)
    }
}
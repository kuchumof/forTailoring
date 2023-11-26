package com.example.fortailoring.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fortailoring.entities.LibraryItem
import com.example.fortailoring.entities.OrderItem
import com.example.fortailoring.entities.OrderListItem
import com.example.fortailoring.entities.OrderListNames

@Database(
    entities = [LibraryItem::class, OrderItem::class,
        OrderListItem::class, OrderListNames::class], version = 1
)
abstract class MainDataBase : RoomDatabase() {

    abstract fun getDao(): Dao

    companion object {

        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context): MainDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "order_list.db"
                ).build()
                instance
            }
        }
    }
}
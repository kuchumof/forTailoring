package com.example.fortailoring.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fortailoring.entities.LibraryItem
import com.example.fortailoring.entities.OrderItem

/*import com.example.fortailoring.entities.OrderListItem
import com.example.fortailoring.entities.OrderListNames*/
/**Класс для создания базы данных либо предоставления доступа к базе данных(инстанция) */
@Database(
    entities = [LibraryItem::class, OrderItem::class //какие таблицы есть(entities(сущности))
        /*OrderListItem::class, OrderListNames::class*/], version = 1
)
abstract class MainDataBase : RoomDatabase() {

    abstract fun getDao(): Dao

    /*использование функции без  инициализации класса*/
    companion object {

        @Volatile //для возможности использования во всех потоках
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context): MainDataBase {
            return INSTANCE ?: synchronized(this) { //для блокировки других потоков(запуска(созданич БД) 1 раз)
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
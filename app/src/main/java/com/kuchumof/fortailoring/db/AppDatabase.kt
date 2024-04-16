package com.kuchumof.fortailoring.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kuchumof.fortailoring.dao.FolderDao
import com.kuchumof.fortailoring.dao.OrderItemDao
import com.kuchumof.fortailoring.model.FolderItemModel
import com.kuchumof.fortailoring.model.OrderItemModel
import kotlin.concurrent.Volatile

//https://medium.com/@majidshahbaz75/kotlin-flows-with-room-database-2d8b4b18790a

@Database(entities = [FolderItemModel::class, OrderItemModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun folderDao(): FolderDao
    abstract fun orderItemDao(): OrderItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "forTailoring.db"
                ).build()
                instance
            }
        }

    }
}

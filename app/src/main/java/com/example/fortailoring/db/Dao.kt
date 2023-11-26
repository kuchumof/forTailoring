package com.example.fortailoring.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fortailoring.entities.OrderItem
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    /*для чтения записей*/
    @Query("SELECT * FROM order_list")
    fun getAllItems(): Flow<List<OrderItem>>

    /*для удаления записи*/
    @Query("DELETE FROM order_list WHERE id IS :id")
    suspend fun deleteItem(id: Int)

    /*для записи*/
    @Insert
    suspend fun insertItem(item: OrderItem)

    /*обновление записи*/
    @Update
    suspend fun updateItem(item: OrderItem)

}
package com.example.fortailoring.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fortailoring.entities.OrderListItem
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    /*для чтения*/
    @Query("SELECT * FROM order_list_item")
    fun getAllItems(): Flow<List<OrderListItem>>

    /*для записи*/
    @Insert
    suspend fun insertItem(item: OrderListItem)


}
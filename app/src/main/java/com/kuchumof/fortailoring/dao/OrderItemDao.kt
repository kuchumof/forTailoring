package com.kuchumof.fortailoring.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kuchumof.fortailoring.model.OrderItemModel
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderItemDao {

    @Query("SELECT * FROM orderItems")
    fun getAllOrderItem(): Flow<List<OrderItemModel>>

    @Insert
    suspend fun insertAllOrderItem(users: List<OrderItemModel>)

    @Delete
    suspend fun deleteOrderItem(user: OrderItemModel)
}

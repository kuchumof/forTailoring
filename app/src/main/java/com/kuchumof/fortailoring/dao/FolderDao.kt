package com.kuchumof.fortailoring.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kuchumof.fortailoring.model.FolderItemModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FolderDao {

    @Query("SELECT * FROM folders WHERE season = 'SUMMER'")
    fun getAllSummer(): Flow<List<FolderItemModel>>

    @Query("SELECT * FROM folders WHERE season = 'WINTER'")
    fun getAllWinter(): Flow<List<FolderItemModel>>

    @Insert
    suspend fun insertAll(users: List<FolderItemModel>)

    @Delete
    suspend fun delete(user: FolderItemModel)

}
package com.example.fortailoring.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "order_list_names")
data class OrderListNames(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "time")
    val time: String,

    @ColumnInfo(name = "allItemCounter")
    val allItemCounter: Int,

    @ColumnInfo(name = "checkedItemCount")
    val checkedItemCount: Int,

    @ColumnInfo(name = "itemsIds")
    val itemsIds: String

) : Serializable

package com.example.fortailoring.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "order_list_item")
data class OrderListItem(

    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "height")
    val height: Int,

    @ColumnInfo(name = "neckCircumference")
    val neckCircumference: Int,

    @ColumnInfo(name = "chestGirth1")
    val chestGirth1: Int,

    @ColumnInfo(name = "itemChecked")
    val itemChecked: Int = 0,

    @ColumnInfo(name = "listId")
    val listId: Int,

    @ColumnInfo(name = "itemType")
    val itemType: String = "item"

)

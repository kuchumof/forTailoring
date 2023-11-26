package com.example.fortailoring.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "order_list")
data class OrderItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "content")
    val content: String,

    @ColumnInfo(name = "time")
    val time: String,

    @ColumnInfo(name = "category")
    val category: String
): Serializable

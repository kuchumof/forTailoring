package com.kuchumof.fortailoring.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kuchumof.fortailoring.constant.TypeOfClothEnum

@Entity(tableName = "orderItems")
data class OrderItemModel(
    @PrimaryKey
    val idOrder: Int,
    @ColumnInfo(name = "idUserOrder")
    val idUserOrder: String,
    @ColumnInfo(name = "idTypeOfClothes")
    val idTypeOfClothes: TypeOfClothEnum,
    @ColumnInfo(name = "dateStartOrder")
    val dateStartOrder: String,
    @ColumnInfo(name = "dateEndOrder")
    val dateEndOrder: String,
)
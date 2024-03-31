package com.kuchumof.fortailoring.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kuchumof.fortailoring.constant.SeasonEnum

//Тестовый комментарий
@Entity(tableName = "folders")
data class FolderItemModel(
    /*TODO
     генерация uuid*/
    @PrimaryKey /*(autoGenerate = true)*/
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "season")
    val seasonEnum: SeasonEnum
)

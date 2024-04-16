package com.kuchumof.fortailoring.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kuchumof.fortailoring.constant.SeasonEnum
import java.util.UUID

//Тестовый комментарий
@Entity(tableName = "folders")
data class FolderItemModel(
    @PrimaryKey
    val id: UUID,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "season")
    val seasonEnum: SeasonEnum
)

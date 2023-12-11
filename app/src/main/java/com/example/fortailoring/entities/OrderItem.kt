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
    @ColumnInfo(name = "height")
    val height: Int? = null,
    @ColumnInfo(name = "neckCircumference")
    val neckCircumference: Int? = null,
    @ColumnInfo(name = "chestGirth1")
    val chestGirth1: Int? = null,
    @ColumnInfo(name = "chestGirth2")
    val chestGirth2: Int? = null,
    @ColumnInfo(name = "chestGirth3")
    val chestGirth3: Int? = null,
    @ColumnInfo(name = "thighCircumference")
    val thighCircumference: Int? = null,
    @ColumnInfo(name = "shoulderWidth")
    val shoulderWidth: Int? = null,
    @ColumnInfo(name = "armLength")
    val armLength: Int? = null,
    @ColumnInfo(name = "shoulderGirth")
    val shoulderGirth: Int? = null,
    @ColumnInfo(name = "wristCircumference")
    val wristCircumference: Int? = null,
    @ColumnInfo(name = "chestWidth1")
    val chestWidth1: Int? = null,
    @ColumnInfo(name = "chestWidth2")
    val chestWidth2: Int? = null,
    @ColumnInfo(name = "chestHeight")
    val chestHeight: Int? = null,
    @ColumnInfo(name = "frontLengthToWaist")
    val frontLengthToWaist: Int? = null,
    @ColumnInfo(name = "backWidth")
    val backWidth: Int? = null,
    @ColumnInfo(name = "backLengthToWaist")
    val backLengthToWaist: Int? = null,
    @ColumnInfo(name = "shoulderHeightObliqueBack")
    val shoulderHeightObliqueBack: Int? = null,
    @ColumnInfo(name = "lengthFromWaistToFloorSide")
    val lengthFromWaistToFloorSide: Int? = null,
    @ColumnInfo(name = "lengthFromWaistToKneeSide")
    val lengthFromWaistToKneeSide: Int? = null,
    @ColumnInfo(name = "lengthOfTheProduct")
    val lengthOfTheProduct: Int? = null,

    @ColumnInfo(name = "time")
    val time: String,

    ) : Serializable

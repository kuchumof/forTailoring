package com.kuchumof.fortailoring.model

import com.kuchumof.fortailoring.constant.TypeOfClothEnum

data class OrderItemModel(
    val idOrder: Int,
    val idUserOrder: String,
    val idTypeOfClothes: TypeOfClothEnum,
    val dateStartOrder: String,
    val dateEndOrder: String,
)
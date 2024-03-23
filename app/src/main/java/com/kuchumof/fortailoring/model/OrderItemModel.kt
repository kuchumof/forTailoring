package com.kuchumof.fortailoring.model

data class OrderItemModel(
    val idOrder: Int,
    val idUserOrder: String,
    val idTypeOfClothes: String,
    val dateStartOrder: String,
    val dateEndOrder: String,
)
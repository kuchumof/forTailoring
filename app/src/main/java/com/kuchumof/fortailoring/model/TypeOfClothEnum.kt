package com.kuchumof.fortailoring.model

import com.kuchumof.fortailoring.R

enum class TypeOfClothEnum {
    DRESS(R.string.Dress);
    /*SUIT("Костюм"),
    HAT("Шапка"),
    SKIRT("Юбка"),
    T_SHIRT("Футболка"),
    BLOUSE("Блузка"),
    CAP("Кепка"),
    PANTS("Брюки"),
    HOODIE("Тостовка"),
    HOODIEHOODIEHOODIEHOODIEHOODIEHOODIE("ТостовкаТостовкаТостовкаТостовкаТостовкаТостовка");*/

    private var translation: Int

    constructor(translation: Int) {
        this.translation = translation
    }
    fun getTranslation(): Int{
        return translation
    }

}
package com.kuchumof.fortailoring.repository

import com.kuchumof.fortailoring.dao.OrderItemDao

// Объявляем DAO как private свойство в конструкторе. Передаем DAO
// вместо всей базы данных, потому что нам необходим доступ только к данному объекту
class OrderItemRepository(private val orderItemDao: OrderItemDao) {

    // Room выполняет все запросы в отдельном потоке.
    // Когда данные изменятся LiveData оповестит подписчиков.
    fun getAllOrderItem() = orderItemDao.getAllOrderItem()

}
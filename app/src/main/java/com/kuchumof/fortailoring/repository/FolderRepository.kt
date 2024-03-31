package com.kuchumof.fortailoring.repository

import com.kuchumof.fortailoring.dao.FolderDao

// Объявляем DAO как private свойство в конструкторе. Передаем DAO
// вместо всей базы данных, потому что нам необходим доступ только к данному объекту
class FolderRepository(private val folderDao: FolderDao) {

    // Room выполняет все запросы в отдельном потоке.
    // Когда данные изменятся LiveData оповестит подписчиков.
    fun getAllSummer() = folderDao.getAllSummer()
    fun getAllWinter() = folderDao.getAllWinter()

}

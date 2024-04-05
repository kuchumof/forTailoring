package com.kuchumof.fortailoring.repository

import com.kuchumof.fortailoring.dao.FolderDao
import com.kuchumof.fortailoring.model.FolderItemModel
import javax.inject.Inject

// Объявляем DAO как private свойство в конструкторе. Передаем DAO
// вместо всей базы данных, потому что нам необходим доступ только к данному объекту
class FolderRepository @Inject constructor (private val folderDao: FolderDao) {

    // Room выполняет все запросы в отдельном потоке.
    // Когда данные изменятся LiveData оповестит подписчиков.
    fun getAllSummer() = folderDao.getAllSummer()
    fun getAllWinter() = folderDao.getAllWinter()

    suspend fun insertAll(folders: List<FolderItemModel>) {
        folderDao.insertAll(folders)
    }

    suspend fun delete(folder: FolderItemModel) {
        folderDao.delete(folder)
    }

}

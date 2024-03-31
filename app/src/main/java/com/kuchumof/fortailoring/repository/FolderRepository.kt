/*
package com.kuchumof.fortailoring.repository

// Объявляем DAO как private свойство в конструкторе. Передаем DAO
// вместо всей базы данных, потому что нам необходим доступ только к данному объекту
class FolderRepository(private val wordDao: WordDao) {

    // Room выполняет все запросы в отдельном потоке.
    // Когда данные изменятся LiveData оповестит подписчиков.
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}*/

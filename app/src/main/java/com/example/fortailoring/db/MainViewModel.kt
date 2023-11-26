package com.example.fortailoring.db

import androidx.lifecycle.*
import com.example.fortailoring.entities.OrderItem
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException


class MainViewModel(database: MainDataBase) : ViewModel() {

    val dao = database.getDao()

    val allItems: LiveData<List<OrderItem>> = dao.getAllItems().asLiveData()
    fun insertItem(item: OrderItem) = viewModelScope.launch {
        dao.insertItem(item)
    }
    fun updateItem(item: OrderItem) = viewModelScope.launch {
        dao.updateItem(item)
    }
    fun deleteItem(id: Int) = viewModelScope.launch {
        dao.deleteItem(id)
    }

    class MainViewModelFactory(val database: MainDataBase) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(database) as T
            }
            throw IllegalArgumentException("UnknownViewModelClass")
        }
    }


}
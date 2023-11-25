package com.example.fortailoring.db

import androidx.lifecycle.*
import com.example.fortailoring.entities.OrderListItem
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException


class MainViewModel(database: MainDataBase) : ViewModel() {

    val dao = database.getDao()

    val allItems: LiveData<List<OrderListItem>> = dao.getAllItems().asLiveData()
    fun insertItem(item: OrderListItem) = viewModelScope.launch {
        dao.insertItem(item)
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
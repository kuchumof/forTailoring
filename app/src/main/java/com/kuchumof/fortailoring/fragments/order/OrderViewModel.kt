package com.kuchumof.fortailoring.fragments.order

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kuchumof.fortailoring.constant.TypeOfClothEnum.*
import com.kuchumof.fortailoring.db.AppDatabase
import com.kuchumof.fortailoring.model.OrderItemModel
import com.kuchumof.fortailoring.repository.OrderItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class OrderViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getAppDatabase(application)
    private val repositoryOrderItem = OrderItemRepository(db.orderItemDao())

    private val _orders = MutableStateFlow<List<OrderItemModel>>(
        emptyList()
    )
    val orders: StateFlow<List<OrderItemModel>> = _orders.asStateFlow()

    init {
        viewModelScope.launch {

            /*db.orderItemDao().insertAllOrderItem(
                listOf(
                    OrderItemModel(
                        101,
                        "Петров П.П.",
                        DRESS,
                        getCurrentTime(),
                        "31.31.2025"
                    ),
                    OrderItemModel(
                        102,
                        "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                        HOODIE,
                        getCurrentTime(),
                        "31.31.2026"
                    ),
                    OrderItemModel(
                        103,
                        "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                        PANTS,
                        getCurrentTime(),
                        "31.31.2026"
                    ),
                    OrderItemModel(
                        104,
                        "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                        BLOUSE,
                        getCurrentTime(),
                        "31.31.2026"
                    ),
                    OrderItemModel(
                        105,
                        "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                        T_SHIRT,
                        getCurrentTime(),
                        "31.31.2026"
                    ),
                    OrderItemModel(
                        106,
                        "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                        SKIRT,
                        getCurrentTime(),
                        "31.31.2026"
                    ),
                    OrderItemModel(
                        107,
                        "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                        HAT,
                        getCurrentTime(),
                        "31.31.2026"
                    ),
                    OrderItemModel(
                        108,
                        "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                        SUIT,
                        getCurrentTime(),
                        "31.31.2026"
                    ),
                    OrderItemModel(
                        109,
                        "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                        SUIT,
                        getCurrentTime(),
                        "31.31.2026"
                    ),
                    OrderItemModel(
                        110,
                        "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                        SUIT,
                        getCurrentTime(),
                        "31.31.2026"
                    )
                )

            )*/
            repositoryOrderItem.getAllOrderItem().collect { newItems ->
                _orders.update { newItems }
            }
        }
    }

    //TODO
    //задавать время создания заявки автоматически из текущего
    // +
    // возможно редактирования(выбора из календарая или ручной ввод)
    private fun getCurrentTime(): String {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return LocalDateTime.now().format(formatter)
    }
}



package com.kuchumof.fortailoring.fragments.order

import androidx.lifecycle.ViewModel
import com.kuchumof.fortailoring.constant.TypeOfClothEnum.*
import com.kuchumof.fortailoring.model.OrderItemModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class OrderViewModel : ViewModel() {

    private val listOrderItemModel = listOf(
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
            DRESS,
            getCurrentTime(),
            "31.31.2026"
        ),
        OrderItemModel(
            103,
            "Дураков С.С.",
            DRESS,
            getCurrentTime(),
            "31.31.2028"
        ),
        OrderItemModel(
            104,
            "Бездельников А.А.",
            HOODIE,
            "01.01.2029",
            "31.31.2030"
        ),
        OrderItemModel(
            105,
            "Сухов К.Н.",
            T_SHIRT,
            getCurrentTime(),
            "31.31.2032"
        )
    )

    private val _orders = MutableStateFlow(listOrderItemModel)
    val orders: StateFlow<List<OrderItemModel>> = _orders.asStateFlow()

    //TODO
    //задавать время создания заявки автоматически из текущего
    // +
    // возможно редактирования(выбора из календарая или ручной ввод)
    private fun getCurrentTime(): String {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return LocalDateTime.now().format(formatter)
    }
}



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
            repositoryOrderItem.getAllOrderItem().collect { newItems ->
                if (newItems.isEmpty()) {
                    setListOrderItem()
                }


                _orders.update { newItems }
            }

        }
    }

    private suspend fun setListOrderItem() {
        db.orderItemDao().insertAllOrderItem(
            listOf(
                OrderItemModel(
                    idOrder = 101,
                    idUserOrder = "Петров П.П.",
                    idTypeOfClothes = DRESS,
                    dateStartOrder = getCurrentTime(),
                    dateEndOrder = "31.31.2025"
                ),
                OrderItemModel(
                    idOrder = 102,
                    idUserOrder = "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                    idTypeOfClothes = HOODIE,
                    dateStartOrder = getCurrentTime(),
                    dateEndOrder = "31.31.2026"
                ),
                OrderItemModel(
                    idOrder = 103,
                    idUserOrder = "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                    idTypeOfClothes = PANTS,
                    dateStartOrder = getCurrentTime(),
                    dateEndOrder = "31.31.2026"
                ),
                OrderItemModel(
                    idOrder = 104,
                    idUserOrder = "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                    idTypeOfClothes = BLOUSE,
                    dateStartOrder = getCurrentTime(),
                    dateEndOrder = "31.31.2026"
                ),
                OrderItemModel(
                    idOrder = 105,
                    idUserOrder = "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                    idTypeOfClothes = T_SHIRT,
                    dateStartOrder = getCurrentTime(),
                    dateEndOrder = "31.31.2026"
                ),
                OrderItemModel(
                    idOrder = 106,
                    idUserOrder = "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                    idTypeOfClothes = SKIRT,
                    dateStartOrder = getCurrentTime(),
                    dateEndOrder = "31.31.2026"
                ),
                OrderItemModel(
                    idOrder = 107,
                    idUserOrder = "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                    idTypeOfClothes = HAT,
                    dateStartOrder = getCurrentTime(),
                    dateEndOrder = "31.31.2026"
                ),
                OrderItemModel(
                    idOrder = 108,
                    idUserOrder = "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                    idTypeOfClothes = SUIT,
                    dateStartOrder = getCurrentTime(),
                    dateEndOrder = "31.31.2026"
                ),
                OrderItemModel(
                    idOrder = 109,
                    idUserOrder = "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                    idTypeOfClothes = SUIT,
                    dateStartOrder = getCurrentTime(),
                    dateEndOrder = "31.31.2026"
                ),
                OrderItemModel(
                    idOrder = 110,
                    idUserOrder = "ИвановИвановИвановИвановИвановИвановИвановИвановИванов ",
                    idTypeOfClothes = SUIT,
                    dateStartOrder = getCurrentTime(),
                    dateEndOrder = "31.31.2026"
                )
            )

        )
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



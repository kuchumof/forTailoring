package com.kuchumof.fortailoring.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kuchumof.fortailoring.databinding.OrderItemBinding
import com.kuchumof.fortailoring.model.OrderItemModel


/**
 * @param dataSet - список элементов данных для отображения.
 */
class OrderAdapter(private val dataSet: List<OrderItemModel>) :
    RecyclerView.Adapter<OrderAdapter.OrderHolder>() {


    /**
     * Класс отвечает за хранение ссылок на элементы интерфейса для отображения одного элемента данных.
     * @param itemBinding - экземпляр сгенерированного класса, позволяющего проще обращаться к эл-ам интерфейса.
     */
    class OrderHolder(private val itemBinding: OrderItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        /**
         * Метод отвечает за вывод на экран одного элемента данных.
         * @param orderItemModel - элемент данных, который выводится на экран.
         */
        fun bind(orderItemModel: OrderItemModel)= with(itemBinding){
            tvIdOrder.text = orderItemModel.idOrder.toString()
            tvSurname.text = orderItemModel.idUserOrder
            tvTypeOfClothes.text = orderItemModel.idTypeOfClothes
            tvDataStartOrder.text = orderItemModel.dateStartOrder
            tvDataEndOrder.text = orderItemModel.dateEndOrder

        }
    }

    /**
     * Метод вызывается при создании новой карточки в списке.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
        //Считываются элементы графического интерфейса,
        //ссылки записываются в переменную itemBinding.
        val itemBinding = OrderItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OrderHolder(itemBinding)
    }

    /**
     *Вызывается, когда старая, ранее созданная, карточка переиспользуется для вывода нового элемента данных.
     * @param OrderHolder - ссылка на старую карточку.
     * @param position - порядковый номер нового элемента данных для вывода.
     */
    override fun onBindViewHolder(orderHolder: OrderHolder, position: Int) {
        orderHolder.bind(dataSet[position])
    }

    /**
     * Возвращает полное кол-во элементов в списке
     */
    override fun getItemCount(): Int {
        return dataSet.size
    }
}
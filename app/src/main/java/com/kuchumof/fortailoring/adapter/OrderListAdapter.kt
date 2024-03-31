package com.kuchumof.fortailoring.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kuchumof.fortailoring.BR
import com.kuchumof.fortailoring.R
import com.kuchumof.fortailoring.databinding.OrderItemBinding
import com.kuchumof.fortailoring.model.OrderItemModel

class OrderListAdapter :
    ListAdapter<OrderItemModel, OrderListAdapter.OrderViewHolder>(OrderDiffCallback()) {

    /**
     * Класс отвечает за хранение ссылок на элементы интерфейса для отображения одного элемента данных.
     * @param itemBinding - экземпляр сгенерированного класса, позволяющего проще обращаться к эл-ам интерфейса.
     */
    class OrderViewHolder(private val itemBinding: OrderItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        /**
         * Метод отвечает за вывод на экран одного элемента данных.
         * @param orderItemModel - элемент данных, который выводится на экран.
         */
        fun bind(order: OrderItemModel) = with(itemBinding) {
            setVariable(BR.order, order)
        }
    }

    /**
     * Метод вызывается при создании новой карточки в списке.
     */
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): OrderViewHolder {
        //Считываются элементы графического интерфейса,
        //ссылки записываются в переменную itemBinding.
        val itemBinding: OrderItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.order_item,
            viewGroup,
            false
        )
        return OrderViewHolder(itemBinding)
    }

    /**
     *Вызывается, когда старая, ранее созданная, карточка переиспользуется для вывода нового элемента данных.
     * @param OrderHolder - ссылка на старую карточку.
     * @param position - порядковый номер нового элемента данных для вывода.
     */
    override fun onBindViewHolder(orderViewHolder: OrderViewHolder, position: Int) {
        orderViewHolder.bind(getItem(position))
    }

    /**
     * Возвращает полное кол-во элементов в списке
     */
    override fun getItemCount(): Int {
        return currentList.size
    }

    private class OrderDiffCallback : DiffUtil.ItemCallback<OrderItemModel>() {

        override fun areItemsTheSame(oldItem: OrderItemModel, newItem: OrderItemModel): Boolean {
            return oldItem.idOrder == newItem.idOrder
        }

        override fun areContentsTheSame(oldItem: OrderItemModel, newItem: OrderItemModel): Boolean {
            return oldItem == newItem
        }
    }
}
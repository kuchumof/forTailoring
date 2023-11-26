package com.example.fortailoring.db

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fortailoring.R
import com.example.fortailoring.databinding.OrderListItemBinding
import com.example.fortailoring.entities.OrderItem


class ItemAdapter(private val listener: Listener) :
    ListAdapter<OrderItem, ItemAdapter.ItemHolder>(ItemComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position), listener)
    }

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = OrderListItemBinding.bind(view)
        fun setData(item: OrderItem, listener: Listener) = with(binding) {
            tvTitle.text = item.title
            tvDescription.text = item.content
            tvTime.text = item.time
            itemView.setOnClickListener {
                listener.onClickItem(item)
            }
            imDelete.setOnClickListener {
                listener.deleteItem(item.id!!)
            }
        }

        companion object {

            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.order_list_item, parent, false)
                )
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<OrderItem>() {

        override fun areItemsTheSame(oldItem: OrderItem, newItem: OrderItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: OrderItem, newItem: OrderItem): Boolean {
            return oldItem == newItem
        }
    }

    interface Listener {

        fun deleteItem(id: Int)
        fun onClickItem(item: OrderItem)
    }
}
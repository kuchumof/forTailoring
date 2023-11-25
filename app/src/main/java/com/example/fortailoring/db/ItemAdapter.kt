package com.example.fortailoring.db

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fortailoring.R
import com.example.fortailoring.databinding.FragmentItemOrderBinding
import com.example.fortailoring.entities.OrderListItem

class ItemAdapter : ListAdapter<OrderListItem, ItemAdapter.ItemHolder>(ItemComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position))
    }


    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = FragmentItemOrderBinding.bind(view)
        fun setData(item: OrderListItem) = with(binding) {
            tvTitle.text = item.title
            edHeight.height = item.height
            edNeckCircumference.height = item.neckCircumference
            edChestGirth1.height = item.chestGirth1
        }

        companion object {

            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.fragment_item_order, parent, false)
                )
            }
        }
    }
    class ItemComparator : DiffUtil.ItemCallback<OrderListItem>(){

        override fun areItemsTheSame(oldItem: OrderListItem, newItem: OrderListItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: OrderListItem, newItem: OrderListItem): Boolean {
            return oldItem == newItem
        }
    }


}
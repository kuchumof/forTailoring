package com.kuchumof.fortailoring.fragments.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kuchumof.fortailoring.adapter.OrderListAdapter
import com.kuchumof.fortailoring.databinding.FragmentOrderBinding
import kotlinx.coroutines.launch


class FragmentOrder : Fragment() {

    private lateinit var binding: FragmentOrderBinding
    private var adapter = OrderListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)

        //Установка менеджера макета - для RecyclerView
        binding.rcOrder.layoutManager = LinearLayoutManager(context)

        //Установка адаптера RecyclerView c использованием OrderListAdapter
        binding.rcOrder.adapter = adapter

        //Получение ссылки на экземпляр класса OrderViewModel
        val viewModel: OrderViewModel by viewModels()
        //Подписка на изменение списка
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                /**@param collect - метод возвращает последнее актуальное состояние списка */
                viewModel.orders.collect {
                    adapter.submitList(it)
                }
            }
        }
        return binding.root
    }
}
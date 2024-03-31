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

    private var _binding: FragmentOrderBinding?=null
    private val binding get() = _binding!!
    private var adapter = OrderListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        binding.rcOrder.layoutManager = LinearLayoutManager(context)
        //Установка адаптера RecyclerView c использованием OrderListAdapter
        binding.rcOrder.adapter = adapter
        val viewModel: OrderViewModel by viewModels()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.orders.collect {
                    adapter.submitList(it)
                }
            }
        }
        return binding.root
    }
}